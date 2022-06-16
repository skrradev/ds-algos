package com.company.leetcode.array;

import com.company.leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PlusOne {

    public int[] plusOne(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 9) {
                nums[i]++;
                break;
            } else {
                nums[i] = 0;
            }
        }
        if (nums[0] == 0) {
            int[] ans = new int[nums.length + 1];
            ans[0] = 1;
            return ans;
        }
        return nums;
    }

    public static void main(String[] args) {

        Set<TreeNode> set = new HashSet<>();



        int[] arr = {9, 9, 9};

        System.out.println("arr = " + Arrays.toString(arr));

        int[] ints = new PlusOne().plusOne(arr);


        System.out.println("ints = " + Arrays.toString(ints));

    }
}
