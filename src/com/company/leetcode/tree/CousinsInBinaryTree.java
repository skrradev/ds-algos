package com.company.leetcode.tree;

public class CousinsInBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        n2.right = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        n3.right = new TreeNode(5);
        root.left = n2;
        root.right = n3;

        boolean cousins = new CousinsInBinaryTree().isCousins(root, 4, 5);
        System.out.println("cousins = " + cousins);


    }

    TreeNode leftParent = null;
    TreeNode rightParent = null;

    public boolean isCousins(TreeNode root, int x, int y) {

        if(root == null) {
            return false;
        }


        int leftDepth = findDepth(root, x, 0);
        int rightDepth = findDepth(root, y, 0);


        return leftDepth == rightDepth && leftParent != rightParent;

    }


    public int findDepth(TreeNode root, int value, int depth) {
        if(root == null) {
            return 0;
        }

        depth ++;

        if(root.left != null && root.left.val == value ) {
            leftParent = root;
        }

        if(root.right != null && root.right.val == value ) {
            rightParent = root;
        }

        if(root.val == value) {
            return depth;
        }

        int left  = findDepth(root.left, value, depth)  ;
        int right = findDepth(root.right, value, depth);

        return left + right;

    }
}
