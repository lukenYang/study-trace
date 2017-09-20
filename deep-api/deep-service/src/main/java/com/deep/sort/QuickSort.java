package com.deep.sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/8/17 0017.
 */
public class QuickSort {

    public static void main(String[] args) {
        int [] list = {9,7,8,4,5,6,3,2,1};
        quickSort(0, list.length - 1, list);
        System.out.println(Arrays.toString(list));

    }


    public static int division(int left, int right, int[] array) {
        int baseNum = array[left];
        while (left < right) {
            while (left < right && baseNum <= array[right]) {
                right--;
            }
            array[left] = array[right];
            while (left < right && baseNum >= array[left]) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = baseNum;
        return left;
    }

    public static void quickSort(int left, int right, int[] array){
        if (left < right) {
            int mid = division(left, right, array);
            quickSort(left, mid - 1, array);
            quickSort(mid + 1, right, array);
        }
    }

}
