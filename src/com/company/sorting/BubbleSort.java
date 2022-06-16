package com.company.sorting;

import java.util.Arrays;

public class BubbleSort {


    public static void main(String[] args) {

        int[] array = new int[]{9, 99,0, 3, -1, 4, 7, 10, 4, 5, 8, 2};
        int length = array.length;
        System.out.println("length = " + length);
        System.out.println("array = " + Arrays.toString(array));
        sort(array);
        System.out.println("array = " + Arrays.toString(array));


    }


    public static void sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }


}
