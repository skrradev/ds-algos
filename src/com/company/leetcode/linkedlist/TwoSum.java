package com.company.leetcode.linkedlist;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {


        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("ints = " + Arrays.toString(ints));

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }

        System.out.println("map = " + map);

        return a;
    }


//    public static int[] twoSum(int[] nums, int target) {
//        int[] a = new int[2];
//
//        for(int i = 0; i < nums.length; i++) {
//            for(int j = 0; j < nums.length; j++) {
//                int sum = nums[i] + nums[j];
//                if(sum == target && j != i) {
//                   a[0] = i;
//                   a[1] = j;
//                    return a;
//                }
//            }
//        }
//
//        return a;
//    }
}
