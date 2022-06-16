package com.company.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[]{9, 99, 0, -1};
        int length = array.length;
        System.out.println("length = " + length);
        System.out.println("array = " + Arrays.toString(array));
        sort(array);
        System.out.println("array = " + Arrays.toString(array));


    }


    public static void sort(int[] array) {

        for (int i = 0; i < array.length-1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                   minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }

            System.out.println("i = " + i + ", " + Arrays.toString(array));
        }


    }
}
