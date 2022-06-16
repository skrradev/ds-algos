package com.company.leetcode.linkedlist;

public class PalindromeLinkedList2 {

    public static void main(String[] args) {

        ListNode linkedList = ListNode.createLinkedList(1, 2, 2, 1);
        linkedList.print();


        boolean palindrome = new PalindromeLinkedList2().isPalindrome(linkedList);
        System.out.println("palindrome = " + palindrome);
    }


    ListNode headPointer = null;

    public boolean isPalindrome(ListNode head) {
        headPointer = head;
        return recursion(head);
    }

    public boolean recursion(ListNode head) {
        if(head == null) {
            return true;
        }

        boolean result = recursion(head.next);

        if(result) {
            if(headPointer.val == head.val) {
                headPointer = headPointer.next;
                return true;
            }
        }

        return false;
    }
}
