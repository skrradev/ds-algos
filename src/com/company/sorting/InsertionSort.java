package com.company.sorting;

import java.util.Arrays;

public class InsertionSort {


    public static void main(String[] args) {

        int[] array = new int[]{9, 99, 0, -7, 6, 3};
        int length = array.length;
        System.out.println("length = " + length);
        System.out.println("array = " + Arrays.toString(array));
        sort(array);
        System.out.println("array = " + Arrays.toString(array));


    }


    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {

            int j = i - 1;
            int k = i;

            while (j >= 0 && array[k] < array[j]) {
                int temp = array[k];
                array[k] = array[j];
                array[j] = temp;
                j--;
                k--;

                System.out.println("k = " + k);
                System.out.println("j = " + j);
            }
            System.out.println("i = " + i + ", " + Arrays.toString(array));


        }


    }


}
