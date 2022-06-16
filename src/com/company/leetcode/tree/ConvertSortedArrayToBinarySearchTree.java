package com.company.leetcode.tree;

public class ConvertSortedArrayToBinarySearchTree {



    public static void main(String[] args) {
        //             0  1  2  3  4
       int [] nums = {-4,-3, 0, 5, 9};

        TreeNode treeNode = new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(nums);

        //treeNode.print2();

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }
        return internal(nums, 0, nums.length - 1);



    }

    private TreeNode internal(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = internal(nums, left, mid - 1);
        node.right = internal(nums, mid+1, right);

        node.print2();
        System.out.println("-----------");




        return node;
    }

}
