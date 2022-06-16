package com.company.leetcode.tree;

import java.util.List;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
            n20.left = new TreeNode(15);
            n20.right = new TreeNode(7);
        root.left = n9;
        root.right = n20;

        int i = new MaximumDepthOfBinaryTree().maxDepth(root);
        System.out.println("i = " + i);


    }



    public int maxDepth(TreeNode root) {
        return internal(root, 0);
    }

    public int internal(TreeNode root, int depth) {
        if(root == null) {
            return depth;
        }

        depth++;

        int leftDepth = internal(root.left, depth);
        int rightDepth = internal(root.right, depth);

        return Math.max(leftDepth, rightDepth);
    }
}
