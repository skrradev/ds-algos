package com.company.leetcode.tree;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumDifferenceBetweenNodeAndAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode n3 = new TreeNode(3);
        TreeNode n10 = new TreeNode(10);
        n3.left = new TreeNode(1);
        TreeNode n6 = new TreeNode(6);
        n6.left = new TreeNode(4);
        n6.right = new TreeNode(7);
        n3.right = n6;



        TreeNode n14 = new TreeNode(14);
        n14.left = new TreeNode(13);
        n10.right = n14;
        root.left = n3;
        root.right = n10;

        root.print2();

        int i = new MaximumDifferenceBetweenNodeAndAncestor().maxAncestorDiff1(root);
        //System.out.println("i = " + i);
        //System.out.println(queue);


    }

    static class Diff {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }

    static  PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return  queue.poll();
    }

    public int maxAncestorDiff1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, root.val, root.val);
    }

    public int helper(TreeNode node, int curMax, int curMin) {
        // if encounter leaves, return the max-min along the path
        if (node == null) {
            return curMax - curMin;
        }
        // else, update max and min
        // and return the max of left and right subtrees
        curMax = Math.max(curMax, node.val);
        curMin = Math.min(curMin, node.val);
        int left = helper(node.left, curMax, curMin);
        int right = helper(node.right, curMax, curMin);
        return Math.max(left, right);
    }



    public Diff dfs(TreeNode node) {

        if(node == null) {
            return null;
        }

        Diff leftDiff = dfs(node.left);
        Diff rightDiff = dfs(node.right);

        Diff diff = new Diff();
        if(leftDiff == null && rightDiff == null) {
            diff.max = node.val;
            diff.min = node.val;
        }

        if(leftDiff != null) {
            queue.add(Math.abs(leftDiff.max - node.val));
            queue.add(Math.abs(leftDiff.min - node.val));

            diff.max = Math.max(diff.max, Math.max(leftDiff.max, node.val));
            diff.min = Math.min(diff.min, Math.min(leftDiff.min, node.val));
        }
        if(rightDiff != null) {
            queue.add(Math.abs(rightDiff.max - node.val));
            queue.add(Math.abs(rightDiff.min - node.val));

            diff.max = Math.max(diff.max, Math.max(rightDiff.max, node.val));
            diff.min = Math.min(diff.min, Math.min(rightDiff.min, node.val));
        }


        return diff;

    }
}
