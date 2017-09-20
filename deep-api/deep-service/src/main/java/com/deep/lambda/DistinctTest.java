package com.deep.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yangliuhua on 2017-6-7.
 */
public class DistinctTest {

    public static void main(String[] args) {
        // 用所有不同的数字创建一个正方形列表
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map( i -> i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
    }
}
