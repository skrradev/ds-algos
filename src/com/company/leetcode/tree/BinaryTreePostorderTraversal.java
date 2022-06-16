package com.company.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {

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

        List<Integer> integers = new BinaryTreePostorderTraversal().postorderTraversal(root);

        System.out.println("integers = " + integers);


    }

    private List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        internal(root);
        return list;
    }


    private void internal(TreeNode root) {

        if (root == null) {
            return;
        }
        internal(root.left);
        internal(root.right);
        list.add(root.val);
    }
}
