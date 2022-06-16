package com.company.leetcode.linkedlist;

public class RemoveLinkedListElements {

    public static void main(String[] args) {

        ListNode linkedList = ListNode.createLinkedList(1, 2, 6, 3, 4, 5, 6);
        linkedList.print();
        ListNode node = new RemoveLinkedListElements().removeElements(linkedList, 6);
        System.out.println("node = " + node);

    }

    //[1,2,6,3,4,5,6]
    //6
    public ListNode removeElements(ListNode head, int val) {

        if(head == null) {
            return null;
        }
        ListNode dummby = new ListNode(0);
        ListNode prev = dummby;
        prev.next = head;
        ListNode current = head;

        while(current != null) {
            if(current.val == val) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return dummby.next;

    }

}
