package com.deep.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by yangliuhua on 2017-6-7.
 */
public class PredicateTest {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, (str) -> str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str) -> str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str) -> true);

        System.out.println("Print no language : ");
        filter(languages, (str) -> false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str) -> str.length() > 4);

        System.out.println();
        System.out.println();


        // 甚至可以用and()、or()和xor()逻辑函数来合并Predicate，
        // 例如要找到所有以J开始，长度为四个字母的名字，你可以合并两个Predicate并传入
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        languages.stream().filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.println("nName, which starts with 'J' and four letter long is : " + n));

        //通过过滤创建一个String列表
        List<String> filtered = languages.stream().filter(x -> x.length() > 3).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", languages, filtered);
    }

    public static void filter(List<String> names, Predicate<String> condition) {
        names.stream().filter(condition::test).forEach(name -> System.out.println(name + " "));

//        names.forEach(name -> {
//            if (condition.test(name)) {
//                System.out.println(name + "-");
//            }
//        });
    }
}
