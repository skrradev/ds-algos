package com.company.leetcode.linkedlist;

import java.util.LinkedList;

public class SwappingNodesInLinkedList {

    public static void main(String[] args) {
        ListNode linkedList = ListNode.createLinkedList(1, 2, 3, 4, 5);
        linkedList.print();

        ListNode node = new SwappingNodesInLinkedList().swapNodes(linkedList, 4);
        node.print();


    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy, front = dummy;

        for (int itr = 0; itr < k; itr++){
            fast = fast.next;
            front = front.next;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        int temp = front.val;
        front.val = slow.val;
        slow.val = temp;

        return dummy.next;
    }
}
