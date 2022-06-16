package com.company.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n2.left = n3;
        root.right = n2;

        List<Integer> integers = new BinaryTreePreorderorderTraversal().preorderTraversal(root);
        System.out.println("integers = " + integers);

    }

    private List<Integer> list= new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        internalWithStack(root);
        return list;
    }

    private void internal(TreeNode root) {

        if(root == null) {
            return;
        }
        list.add(root.val);
        internal(root.left);
        internal(root.right);
    }

    private void internalWithStack(TreeNode root) {
        LinkedList<TreeNode> s = new LinkedList<>();
        s.push(root);

        while (s.size() > 0)
        {

            TreeNode pop = s.pop();
            if(pop.right != null) {
                s.push(pop.right);
            }

           if(pop.left != null) {
               s.push(pop.left);
           }


           list.add(pop.val);
        }
    }
}
