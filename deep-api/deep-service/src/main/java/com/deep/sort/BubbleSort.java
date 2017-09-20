package com.deep.sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
public class BubbleSort {

    public static void main(String[] args) {
//        int [] list = {9,7,8,4,5,6,13,2,1,10,16,11,3};
        int [] list = {6,5,4,3,2,1};
        bubbleSort(list);
//        System.out.println(Arrays.toString(list));

    }

    private static void bubbleSort(int[] list){
        int length = list.length;
        int temp;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (list[j] > list[j+1]) {
                    temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
            System.out.println(Arrays.toString(list));
        }
    }

}
