package com.company.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n2.left = n3;
        root.right = n2;

        List<Integer> integers = new BinaryTreeInorderTraversal().inorderTraversal(root);
        System.out.println("integers = " + integers);

    }

    private List<Integer> list= new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        internalWithStack(root);
        return list;
    }

    private void internal(TreeNode root) {

        if(root == null) {
            return;
        }
        internal(root.left);
        list.add(root.val);
        internal(root.right);
    }

    private void internalWithStack(TreeNode root) {
        LinkedList<TreeNode> s = new LinkedList<>();

        TreeNode curr = root;
        while (curr != null || s.size() > 0)
        {
            while (curr !=  null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();

           list.add(curr.val);

            curr = curr.right;
        }
    }
}
