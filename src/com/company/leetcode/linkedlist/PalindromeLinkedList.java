package com.company.leetcode.linkedlist;

public class PalindromeLinkedList {

    public static void main(String[] args) {

        ListNode linkedList = ListNode.createLinkedList(1, 2, 2, 1);
        linkedList.print();


        boolean palindrome = new PalindromeLinkedList().isPalindrome(linkedList);
        System.out.println("palindrome = " + palindrome);
    }


    public boolean isPalindrome(ListNode head) {

        var mid = getMiddle(head);
        mid.print();

        var reversed = reverse(mid);
        reversed.print();


        while(reversed != null) {
            if(reversed.val != head.val) {
                return false;
            }
            reversed = reversed.next;
            head = head.next;
        }
        return false;

    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        var current = head;

        while(current != null) {
            var tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }

        return prev;
    }

    private ListNode getMiddle(ListNode head) {
        var fast = head;
        var slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
