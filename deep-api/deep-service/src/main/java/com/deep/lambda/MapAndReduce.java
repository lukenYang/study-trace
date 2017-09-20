package com.deep.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yangliuhua on 2017-6-7.
 */
public class MapAndReduce {
    public static void main(String[] args) {
        // 不使用lambda表达式为每个订单加上12%的税
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double total = 0;
        for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            System.out.println(price);
            total = total + price;
        }
        System.out.println("Total : " + total);
        System.out.println();
        // 使用lambda表达式
        costBeforeTax.stream().map((cost) -> cost + .12*cost).forEach(System.out::println);
        double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);

        // 将字符串换成大写并用逗号链接起来
        List<String> G7 = Arrays.asList("USA", "China", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);
    }
}
