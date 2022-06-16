package com.company.leetcode.tree;

import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class AverageOfLevelsInBinaryTree {

    public static void main(String[] args) {

        TreeNode root = TreeNode.build(new Integer[]{3,9,20,15,7});
        root.print2();

        new AverageOfLevelsInBinaryTree().internal(root, 0);


        List<Double> list = new ArrayList<>(map.size());
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            double asDouble = entry.getValue().stream().mapToInt(it -> it).average().getAsDouble();
            list.add(asDouble);
        }

    }

//    public List<Double> averageOfLevels(TreeNode root) {
//
//    }


    static Map<Integer, List<Integer>> map = new HashMap<>();

    public  void internal(TreeNode root, int level) {
        if(root == null) {
            return;
        }

        List<Integer> integers = map.get(level);
        if(integers == null) {
            List<Integer> objects = new ArrayList<>();
            objects.add(root.val);
            map.put(level, objects);
        } else {
            List<Integer> integers1 = map.get(level);
            integers1.add(root.val);
        }

        internal(root.left, level + 1);
        internal(root.right, level + 1);


    }
}
