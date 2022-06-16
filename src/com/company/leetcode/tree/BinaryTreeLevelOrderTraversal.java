package com.company.leetcode.tree;

import com.company.leetcode.tree.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode build = TreeNode.build(new Integer[]{3, 9, 20, null, null, 15, 7});
        build.print2();

        Map<System, System> map = null;

        Set<System> set = null;

       // set.retainAll()

        new BinaryTreeLevelOrderTraversal().levelOrder(build);

    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {


            var size = q.size();
            for(int i=0; i< size; i++) {
                var node = q.poll();

                System.out.print(node.val + " ");

                if(node.left != null) {
                    q.offer(node.left);
                }

                if(node.right != null) {
                    q.offer(node.right);
                }


            }
            System.out.println();

        }

        return null;

    }
}
