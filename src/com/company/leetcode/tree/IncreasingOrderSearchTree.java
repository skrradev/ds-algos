package com.company.leetcode.tree;

public class IncreasingOrderSearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);

        TreeNode n4 = new TreeNode(4);
        n4.left =  new TreeNode(3);

        root.right = n4;

        root.print2();



        //TreeNode treeNode = new IncreasingOrderSearchTree().increasingBST(root);

        //System.out.println("treeNode = " + treeNode);

    }



    TreeNode prev = null;
    TreeNode newRoot = null;

    boolean isRootNode = true;

    public TreeNode increasingBST(TreeNode root) {
        internal(root);
        return newRoot;
    }

    public void internal(TreeNode node) {
        if(node == null) {
            return;
        }

        internal(node.left);

        if(prev != null) {
            prev.left = null;
            prev.right = node;
        }

        if(isRootNode) {
            newRoot = node;
            isRootNode = false;
        }

        prev = node;

        internal(node.right);

    }
}
