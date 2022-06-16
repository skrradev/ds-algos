package com.company.leetcode.linkedlist;

public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        ListNode node = ListNode.createLinkedList(1, 2, 3, 4, 5, 6);

        ListNode node1 = new MiddleOfTheLinkedList().middleNode(node);

        node1.print();


    }


    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
