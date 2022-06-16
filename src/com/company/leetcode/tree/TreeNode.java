package com.company.leetcode.tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    private int level;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    public void print2() {
        printTree(List.of(this), depth(this, 0));
    }

    public void printTree(List<TreeNode> levelNodes, int level) {

        List<TreeNode> nodes = new ArrayList<TreeNode>();

        //indentation for first node in given level
        printIndentForLevel(level);

        for (TreeNode treeNode : levelNodes) {

            //print node data
            System.out.print(treeNode == null ? " " : treeNode.val);

            //spacing between nodes
            printSpacingBetweenNodes(level);

            //if its not a leaf node
            if (level > 1) {
                nodes.add(treeNode == null ? null : treeNode.left);
                nodes.add(treeNode == null ? null : treeNode.right);
            }
        }
        System.out.println();

        if (level > 1) {
            printTree(nodes, level - 1);
        }
    }

    private void printIndentForLevel(int level) {
        for (int i = (int) (Math.pow(2, level - 1)); i > 0; i--) {
            System.out.print(" ");
        }
    }

    private void printSpacingBetweenNodes(int level) {
        //spacing between nodes
        for (int i = (int) ((Math.pow(2, level - 1)) * 2) - 1; i > 0; i--) {
            System.out.print("\u25A0");
        }
    }


    public void print() {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.offer(this);

        int depth = depth(this, 0);
        int padding = depth * (depth - 1);

        int curLevel = 0;

        for (int i = 1; i < padding; i++) {
            System.out.print('\u25A1');
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();

            if (curLevel != node.level) {
                System.out.println();
                padding = padding / 2;
                for (int i = 1; i < padding; i++) {
                    System.out.print('\u25A1');
                }
                curLevel++;
            }

            System.out.print(node.val);

            for (int i = 1; i < padding * 2; i++) {
                System.out.print('\u25A1');
            }


            if (node.right != null) {
                node.right.level = node.level + 1;
                stack.offer(node.right);
            }
            if (node.left != null) {
                node.left.level = node.level + 1;
                stack.offer(node.left);
            }


        }


    }

    public int depth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }

        depth++;

        int leftDepth = depth(root.left, depth);
        int rightDepth = depth(root.right, depth);

        return Math.max(leftDepth, rightDepth);
    }

  // 0  1   2    3     4     5   6
 // [3, 9,  20, null, null, 15,  7]
    public static TreeNode build(Integer[] nodes) {


        Queue<TreeNode> queue = Arrays.stream(nodes)
                .map(val1 -> val1 == null ? null : new TreeNode(val1))
                .collect(Collectors.toCollection(LinkedList::new));

        Queue<TreeNode> queue2 = new LinkedList<>();
        TreeNode root = queue.poll();
        queue2.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node =  queue2.poll();
            node.left = queue.poll();
            node.right = queue.poll();

            queue2.offer(node.left);
            queue2.offer(node.right);
        }

        return root;

    }

//    public static TreeNode internal(Integer[] nodes, int right, int left) {
//
//             TreeNode node = new TreeNode()
//
//
//    }
}
