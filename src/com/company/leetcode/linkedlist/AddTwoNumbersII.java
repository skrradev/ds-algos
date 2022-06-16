package com.company.leetcode.linkedlist;

public class AddTwoNumbersII {

    int carryOver = 0;

        ///[7,2,4,3,6]
        //[5,6,4]
    public static void main(String[] args) {
        ListNode l1 = ListNode.createLinkedList(8, 7, 2, 4, 3, 6);
        ListNode l2 = ListNode.createLinkedList(5,6,4);



        ListNode node = new AddTwoNumbersII().addTwoNumbers(l1, l2);
        System.out.println("node = " + node);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int l1Size = getSize(l1);
        int l2Size =  getSize(l2);

        int diff = Math.abs(l1Size - l2Size);
        if(l1Size > l2Size) {
            l2 = addZeros(l2, diff);
        }  else if(l2Size > l1Size)  {
            l1 = addZeros(l1, diff);
        }

        System.out.println(l1);
        System.out.println(l2);

        helper(l1, l2);

        return l1;
    }


    private int getSize(ListNode node) {
        int size = 0;
        while(node != null) {
            size++;
            node = node.next;
        }

        return size;
    }



    private ListNode addZeros(ListNode node, int times) {
        ListNode head = new ListNode(0);

        int count = 0;
        ListNode current = head;
        while(count < times - 1) {
            current.next = new ListNode(0);
            current = current.next;
            count++;
        }

        current.next = node;
        return head;
    }



    private void helper (ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return;
        }

        helper(l1.next, l2.next);

        if(carryOver == 0) {
            int val = l1.val + l2.val;
            if(val > 9) {
                val = val % 10;
                l1.val = val;
                carryOver = 1;
            } else {
                l1.val = val;
                carryOver = 0;
            }
        } else {
            int val = l1.val + l2.val + carryOver;
            if(val > 9) {
                val = val % 10;
                l1.val = val;
                carryOver = 1;
            } else {
                l1.val = val;
                carryOver = 0;
            }

        }
    }
}
