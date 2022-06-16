package com.company.leetcode.linkedlist;

public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        //[4, 1,  8,4,5]
        //[5,6,1, 8,4,5]
        ListNode c = ListNode.createLinkedList(8,4,5);

        ListNode a = new ListNode(4);
        a.next = new ListNode(1);
        a.next.next = c;

        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(1);
        b.next.next.next = c;

        ListNode intersectionNode = new IntersectionOfTwoLinkedLists().getIntersectionNode(a, b);

        System.out.println("intersectionNode = " + intersectionNode.val);


    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);

        int sizeDiff = Math.abs(sizeA - sizeB);

        ListNode waitingList;
        ListNode firstList;


        if(sizeA > sizeB) {

            firstList = headA;
            waitingList = headB;
        }  else {

            firstList = headB;
            waitingList = headA;
        }


        int index = 0;
        while(firstList != null) {
            if(index >= sizeDiff) {
                System.out.println("first " + firstList.val + " sec" + waitingList.val);
                if(firstList == waitingList) {
                    return firstList;
                }
                waitingList = waitingList.next;
            }
            index++;
            firstList = firstList.next;
        }

        return null;


    }

    private int getSize(ListNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head= head.next;
        }
        return count;
    }

}
