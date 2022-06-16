package com.company.leetcode.tree;

public class BalancedBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode n2l = new TreeNode(2);
        TreeNode n2r = new TreeNode(2);
                 TreeNode n3l  = new TreeNode(3);
                 n3l.left  = new TreeNode(4);
                 n3l.right  = new TreeNode(4);
                n2l.left = n3l;
                n2l.right = new TreeNode(3);
        root.left = n2l;
        root.right = n2r;


            boolean balanced = new BalancedBinaryTree().isBalanced(root);
            System.out.println("balanced = " + balanced);



    }



    public boolean isBalanced(TreeNode root) {

        if(root == null) {
            return true;
        }

        try {
            internal(root, 0);
            return true;
        } catch (RuntimeException e) {
        return false;
        }

    }

    private boolean isBalanced = true;

    private int internal(TreeNode root, int depth) {
        if(root == null) {
            return depth;
        }


        depth++;

        int leftDepth = internal(root.left, depth);
        int rightDepth = internal(root.right, depth);



        if(Math.abs(leftDepth - rightDepth) > 1) {
            throw new RuntimeException();
        }

        int maxDepth = Math.max(leftDepth, rightDepth);

        return maxDepth;
    }
}
