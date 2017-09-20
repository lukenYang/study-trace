package com.deep.sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/8/19 0019.
 */
public class MergeSort {

    public static void main(String[] args) {
        int [] array ={5,4,6,9,8,7,3,2,1};
        mergeSort(0, array.length - 1, array, new int[array.length]);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int left, int right, int[] array, int[]tempArray) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(left, middle, array, tempArray);
            mergeSort(middle + 1, right, array, tempArray);
            merge(left, right, middle + 1, array, tempArray);
        }
    }


    public static void merge(int left, int right, int middle, int[] array, int[]tempArray) {
        int leftEnd = middle - 1;
        int rightStart = middle;
        int tempIndex = left;
        int tempArrayLength = right - left + 1;
        while (left <= leftEnd && rightStart <= right) {
            if (array[left] < array[rightStart]) {
                tempArray[tempIndex++] = array[left++];
            } else {
                tempArray[tempIndex++] = array[rightStart++];
            }
        }
        while (left <= leftEnd) {
            tempArray[tempIndex++] = array[left++];
        }
        while (rightStart <= right) {
            tempArray[tempIndex++] = array[rightStart++];
        }

        for (int i = 0; i < tempArrayLength; i++) {
            array[right] = tempArray[right];
            right--;
        }
    }
}
