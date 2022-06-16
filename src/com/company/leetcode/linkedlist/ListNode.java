package com.company.leetcode.linkedlist;

import java.util.StringJoiner;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    String print() {
        ListNode cur = this;
        StringJoiner joiner = new StringJoiner(", ", "[ ", "]");

        while (cur != null) {
            joiner.add(String.valueOf(cur.val));
            cur = cur.next;
        }

        return joiner.toString();
    }

    @Override
    public String toString() {
        return val + " " + print();
    }

    public static ListNode createLinkedList(int... args) {
        ListNode head = new ListNode(args[0]);
        ListNode prev = head;
        ListNode element;

        for (int i = 1; i < args.length; i++) {
            element = new ListNode(args[i]);
            prev.next = element;
            prev = element;
        }

        return head;
    }


}