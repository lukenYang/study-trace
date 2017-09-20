package com.deep.sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/8/20 0020.
 */
public class SelectSort {

    public static void main(String[] args) {
        int [] array ={5,4,6,9,8,7,3,2,1};
        selectSort(array);
//        System.out.println(Arrays.toString(selectSort(array)));
    }

    public static int[] selectSort(int[] list) {
        int temp;
        int index;
        int length = list.length;
        for (int i = 0; i < length; i++) {
            index = i;
            for (int j = i + 1; j < length; j++) {
                if (list[index] > list[j]) {
                    index = j;
                }
            }
            if (index != i) {
                temp = list[index];
                list[index] = list[i];
                list[i] = temp;
            }
            System.out.println(Arrays.toString(list));
        }
        return list;
    }
}

//for (int i = 0; i < length; i++) {
//        index = i;
//        for (int j = i + 1; j < length; j++) {
//        if (list[index] > list[j]) {
//        index = j;
//        }
//        }
//        if (index != i) {
//        temp = list[index];
//        list[index] = list[i];
//        list[i] = temp;
//        }
//        System.out.println(Arrays.toString(list));
//        }
//
//        return list;
