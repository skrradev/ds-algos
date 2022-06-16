package com.company;

import java.util.Arrays;

public class ArrayChunk {




    public static void main(String[] args) {

        int[][] ints = chunkArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);
        System.out.println("ints = " + Arrays.deepToString(ints));


    }

    public static int[][] chunkArray(int[] array, int chunkSize) {
        int numOfChunks = (int)Math.ceil((double)array.length / chunkSize);
        int[][] output = new int[numOfChunks][];

        for(int i = 0; i < numOfChunks; ++i) {
            int start = i * chunkSize;
            int length = Math.min(array.length - start, chunkSize);

            int[] temp = new int[length];
            System.arraycopy(array, start, temp, 0, length);
            output[i] = temp;
        }

        return output;
    }



//    // 1, 2, 3,    4, 5, 6,    7
//    static int[][] chunkArray(int[] array, int length) {
//        int mainArrayLength = Math.round(array.length / (float) length);
//
//
//        int[][] mainArray = new int[mainArrayLength][];
//
//        int mainArrayCounter = 0;
//        int secondArrayCounter = 0;
//
//
//
//        for (int i = 0; i < array.length; i++) {
//            int[] innerArray;
//            int elementsLeft = array.length - (i + 1);
//
//            if(elementsLeft > length) {
//                innerArray = new int[length];
//            } else {
//                innerArray = new int[elementsLeft];
//            }
//
//            innerArray[secondArrayCounter++] = array[i];
//
//            if (secondArrayCounter >= length) {
//                mainArray[mainArrayCounter++] = innerArray;
//                secondArrayCounter = 0;
//
//
//            }
//        }
//        return mainArray;
//    }
}
