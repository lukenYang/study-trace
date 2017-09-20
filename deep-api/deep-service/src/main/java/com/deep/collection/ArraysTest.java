package com.deep.collection;


import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/8/27 0027.
 */
public class ArraysTest {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(3);
        list1.add(4);
        list1.add(8);
        list1.add(9);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(2);
        list2.add(3);
        list2.add(7);
        list2.add(30);
        list2.add(40);

        list1.retainAll(list2);
        System.out.println(list1);
    }
}
