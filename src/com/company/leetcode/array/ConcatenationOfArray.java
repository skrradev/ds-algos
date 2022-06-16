package com.company.leetcode.array;

public class ConcatenationOfArray {

    public static void main(String[] args) {

    }



    public int[] getConcatenation(int[] nums) {

        int[] ans = new int[nums.length*2];


        for(int i = 0; i < nums.length *2; i += nums.length) {

            for(int j = 0,  k = i; j < nums.length; j++, k++) {
                ans[k] = nums[j];
            }
        }

        return ans;

    }
}
