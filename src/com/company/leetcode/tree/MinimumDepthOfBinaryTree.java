package com.company.leetcode.tree;

public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        root.right = n3;
        n3.right = n4;
        n4.right = n5;
        n5.right = n6;

        int i = new MinimumDepthOfBinaryTree().minDepth1(root);
        System.out.println("i = " + i);

        root.print();


    }


    public int minDepth2(TreeNode root)
    {
        if(root!=null && root.left==null && root.right==null)  return 1;
        if(root==null)  return 0;

        int left=Integer.MAX_VALUE;
        int right=Integer.MAX_VALUE;

        if(root.left!=null)
        {
            left=minDepth2(root.left);
        }
        if(root.right!=null)
        {
            right=minDepth2(root.right);
        }
        return Math.min(left,right)+1;
    }

    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int leftDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            leftDepth = minDepth1(root.left);
        }

        int rightDepth = Integer.MAX_VALUE;
        if (root.right != null) {
            rightDepth = minDepth1(root.right);
        }

        return Math.min(leftDepth, rightDepth) + 1;
    }


    public int minDepth(TreeNode root) {
        return internal(root, 0);
    }

    public int internal(TreeNode node, int depth) {
        if(node == null) {
            return depth;
        }

        depth++;

        if(node.right == null && node.left == null) {
            return depth;
        }

        int leftDepth = internal(node.left, depth);
        int rightDepth = internal(node.right, depth);

        if(leftDepth == 1) {
            leftDepth = Integer.MAX_VALUE;
        }
        if(rightDepth == 1) {
            rightDepth = Integer.MAX_VALUE;
        }


        return  Math.min(leftDepth, rightDepth);

    }
}


