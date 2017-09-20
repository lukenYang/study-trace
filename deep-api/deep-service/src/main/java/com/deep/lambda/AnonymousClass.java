package com.deep.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yangliuhua on 2017-6-7.
 */
public class AnonymousClass {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();

//      (params) -> expression
//      (params) -> statement
//      (params) -> { statements }
        //(int even, int odd) -> even + odd
        new Thread(()-> System.out.println("lambda")).start();

        List<String> words = new ArrayList<>();

        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        Collections.sort(words, (x, y)-> x.length() - y.length());
    }
}
