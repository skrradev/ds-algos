package com.company;

import java.util.Arrays;
import java.util.StringJoiner;

public class Array {

    private int[] backingArray;
    private static final int DEFAULT_CAPACITY = 10;
    private int marker = 0;

    public Array(int length) {
        if (length == 0) {
            throw new IllegalArgumentException("length can't be zero");
        }

        backingArray = new int[length];
    }

    public Array() {
        backingArray = new int[DEFAULT_CAPACITY];
    }

    public void print() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < marker; i++) {
            joiner.add(String.valueOf(backingArray[i]));
        }
        System.out.println(joiner);
    }

    @Deprecated
    public void printReal() {
        System.out.println(Arrays.toString(backingArray));
    }

    public void insert(int value) {
        if (marker == backingArray.length) {
            int[] tempArray = new int[backingArray.length * 2];

            for (int i = 0; i < backingArray.length; i++) {
                tempArray[i] = backingArray[i];
            }
            backingArray = tempArray;
        }


        backingArray[marker++] = value;

    }

    ////            +
    // [3, 2, 4, 5, 9, ---    0, 0]
    public void removeAt(int index) {
        for (int i = index; i < marker; i++) {
            backingArray[i] = backingArray[i + 1];
        }
        marker--;
    }


}
