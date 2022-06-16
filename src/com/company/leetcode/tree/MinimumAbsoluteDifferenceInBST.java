package com.company.leetcode.tree;

public class MinimumAbsoluteDifferenceInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode n48 = new TreeNode(48);
        n48.left = new TreeNode(12);
        n48.right = new TreeNode(99);

        root.left = new TreeNode(-60);
        root.right = n48;

        int minimumDifference = new MinimumAbsoluteDifferenceInBST().getMinimumDifference1(root);
        System.out.println("minimumDifference = " + minimumDifference);

    }



    int ans = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference1(TreeNode root) {
        solve(root);
        return ans;
    }

    void solve(TreeNode root) {
        if(root == null) return;
        solve(root.left);
        if(prev != null) {
            ans = Math.min(ans, Math.abs(root.val - prev.val));
        }
        prev = root;
        solve(root.right);
    }


    public int getMinimumDifference(TreeNode root) {
        inner(root, null);
        return min;
    }

    int min = Integer.MAX_VALUE;

    public void inner(TreeNode root, TreeNode parent) {
      if(root == null) {
          return;
      }


      if(parent != null) {
          min = Math.min(min, Math.abs(parent.val - root.val));
      }

        inner(root.left, root);
        inner(root.right, root);

    }
}
