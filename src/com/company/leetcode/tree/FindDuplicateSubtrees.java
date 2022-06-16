package com.company.leetcode.tree;

import java.util.*;

public class FindDuplicateSubtrees {

    public static void main(String[] args) {



    }



    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        fillHashSet(root);
        return new ArrayList<>(result);
    }

    Map<Integer, TreeNode> map = new HashMap<>();
    Set<TreeNode> result = new LinkedHashSet<>();

    public int fillHashSet(TreeNode root) {

        if(root == null) {
            return 0;
        }

        boolean sholudput = true;
        if(map.containsKey(root.val)) {
            TreeNode original = map.get(root.val);
            if(isSubtreeEqual(original, root) && !result.contains(original)) {
                result.add(original);
                sholudput = false;
            }
        }
        if(sholudput) {
            map.put(root.val, root);

        }





        int leftHash = fillHashSet(root.left) - 21;
        int rightHash = fillHashSet(root.right) + 33;

        int hash = leftHash + 67 + rightHash + root.val;

        return hash;



    }

    public boolean isSubtreeEqual(TreeNode original, TreeNode copy) {


        if(original != null) {
            System.out.println("orogin " + original.val);

        }

        if(copy != null) {
            System.out.println("copy " + copy.val);

        }

        if(original == null && copy == null) {
            return true;
        }

        if(original == null || copy == null) {
            return false;
        }


        return original.val == copy.val &&
                isSubtreeEqual(original.left, copy.left) &&
                isSubtreeEqual(original.right, copy.right);
    }

}
