package com.company.leetcode.linkedlist;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class exampl4 {

//    key1
//            value
//    key2
//            value2
//    key3
//            value3
    public static void main(String[] args) {
        generateNumbers();
    }

    public static void generateNumbers() {
        for (int i = 0; i < 10; i++) {
            System.out.println("00" +i);
        }

        for (int i = 10; i < 100; i++) {
            System.out.println("0" +i);
        }


        for (int i = 100; i < 1000; i++) {
            System.out.println(i);
        }

    }

    public static int uniqueMapVal(HashMap<String, String> map) {

        HashMap<String, Integer> counterMap = new HashMap<>();
        for (String value : map.values()) {
            Integer count = counterMap.get(value);
            if (count == null) {
                counterMap.put(value, 1);
            } else {
                counterMap.put(value, count+1);
            }
        }
        int count = 0;
        for (Integer value : counterMap.values()) {
            if (value == 1) {
                count++;
            }
        }
        return count;
    }


    public static void permutations(int n) {
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    if(k != i && k != j && i != j){
                        System.out.println(i + "" + j + "" + k);
                    }
                }
            }
        }
    }
}
