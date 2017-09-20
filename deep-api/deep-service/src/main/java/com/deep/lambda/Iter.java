package com.deep.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yangliuhua on 2017-6-7.
 */
public class Iter {

    public static void main(String[] args) {

        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        // Java 8之前：
        for (String feature : features) {
            System.out.println(feature);
        }
        // Java 8之后：
        features.forEach(e -> System.out.println(e));

        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
        // 看起来像C++的作用域解析运算符
        features.forEach(System.out::println);
    }
}
