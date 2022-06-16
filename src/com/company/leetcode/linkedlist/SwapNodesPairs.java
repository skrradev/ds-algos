package com.company.leetcode.linkedlist;

import static com.company.leetcode.linkedlist.ListNode.createLinkedList;

public class SwapNodesPairs {

    public static void main(String[] args) {


        
        ListNode linkedList = createLinkedList(1, 2, 3, 4);
        linkedList.print();

        ListNode listNode = swapPairs(linkedList);
        listNode.print();


    }

    public static ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;


        while (current != null && current.next != null) {
            prev.next = current.next;
            ListNode temp = current.next; //2

            current.next = current.next.next;
            temp.next = current;

            prev = current;
            current = current.next;
        }

        return dummy.next;
    }
}
