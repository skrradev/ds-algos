package com.company.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class FindModeInBinarySearchTree {

    Integer num = null;
    int count = 0;
    int mode = 0;

    static List<Integer> modes = new ArrayList<>();


    public static void main(String[] args) {
        List<Integer> list = List.of(6, 7, 7, 7, 8, 8, 8, 9, 9, 9 , 10);


        //Math.pow()

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(4);
        queue.add(3);
        queue.add(4);
        queue.add(2);
        queue.add(0);
        queue.add(4);
        queue.add(5);

        System.out.println("queue = " + queue);

        new FindModeInBinarySearchTree().findMode1(list);

   ///

            System.out.println("modes = " + modes);


    }

    public void findMode1(List<Integer> list) {
        for (Integer element : list) {

            if(num == null || !num.equals(element)) {
                num = element;
                count = 1;
            } else {
                count++;
            }

            if( count > mode) {
                modes.clear();
                mode = count;
                //modes.add(element);
            } if(count == mode) {
                modes.add(element);
            }


        }




    }


    public int[] findMode(TreeNode root) {
        return null;
    }
}
