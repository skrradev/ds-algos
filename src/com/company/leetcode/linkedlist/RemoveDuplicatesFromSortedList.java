package com.company.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {

        ListNode linkedList = ListNode.createLinkedList(1, 1, 2, 3, 3);

        ListNode node = new RemoveDuplicatesFromSortedList().deleteDuplicates(linkedList);
        node.print();

    }

        //1, 1, 2, 3, 3
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();

        var dummy = new ListNode(0);
        dummy.next = head;
        var prev = dummy;
        var current = head;

        while(current != null) {
            System.out.println("current1 = " + current.val);
            if(set.contains(current.val)) {
                System.out.println("cotaint = " + current.val);
                prev.next = current.next;
            } else {
                set.add(current.val);
                prev = current;
            }
            current = current.next;
        }

        return dummy.next;
    }
}
