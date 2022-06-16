package com.company.leetcode.tree;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;

public class SubtreeOfAnotherTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
            TreeNode n4 = new TreeNode(4);
                TreeNode n1 = new TreeNode(1);
                TreeNode n2 = new TreeNode(2);
            n4.left = n1;
            n4.right = n2;
            TreeNode n5 = new TreeNode(5);
        root.left = n4;
        root.right = n5;

        root.print();

        TreeNode n6 = new TreeNode(4);
            TreeNode n7 = new TreeNode(1);
            TreeNode n8 = new TreeNode(2);
                    n8.left = new TreeNode(9);
        n6.left = n7;
        n6.right = n8;

        //dfs(root);
        System.out.println("-------");
        dfsStack(root);
        //bfs(root);

        //boolean helper = isSubtree(root, n6);
       // System.out.println("helper = " + helper);

        

    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        System.out.println("root = " + root + " subroot " +  subRoot);

        if(root == null) {
            return false;
        }

        if(root.val == subRoot.val && isTreesEqual(root, subRoot)) {
            return true;
        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }


    private static boolean isTreesEqual(TreeNode root, TreeNode subRoot) {
        System.out.println("            root = " + root + " subroot " +  subRoot);

        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        if (root.val != subRoot.val) {
            return false;
        }

        boolean left = isTreesEqual(root.left, subRoot.left);
        boolean right = isTreesEqual(root.right, subRoot.right);

        return left && right;
    }


    public static void dfsStack(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);


        while (!stack.isEmpty()) {
            System.out.println("stack = " + stack);
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }



        }


    }

    public static void dfs(TreeNode node) {
        if(node == null) {
            return;
        }

        System.out.println("node = " + node.val);

        dfs(node.left);
        //System.out.println("Going right of " + node.val);
        dfs(node.right);

    }


    public static void bfs(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();

            if(poll == null) {
                continue;
            }
            System.out.println("poll = " + poll);

            queue.offer(poll.left);
            queue.offer(poll.right);
        }

    }



}
