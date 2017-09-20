package com.deep.sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/8/20 0020.
 */
public class InsertSort {

    public static void main(String[] args) {
        int [] array ={5,4,6,9,8,7,3,2,1};
        System.out.println(Arrays.toString(insertSort(array)));
    }

    public static int[] insertSort(int[] list) {
        int length = list.length;
        for (int i = 1; i < length; i++) {
            int temp = list[i];
            int j;
            for (j = i - 1; j >= 0 && temp < list[j] ; j--) {
                list[j + 1] = list[j];
            }
            list[j + 1] = temp;
        }
        return list;
    }
}
