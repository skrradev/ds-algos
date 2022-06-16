package com.company.leetcode.linkedlist;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Intersection {


    public static void main(String[] args) {

        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);


        ListNode headB = new ListNode(9);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(7);
        headB.next.next.next = new ListNode(10);
        headB.next.next.next.next = new ListNode(-7);
        headB.next.next.next.next.next = headA.next.next;
        headB.next.next.next.next.next.next = headA.next.next.next;
        headB.next.next.next.next.next.next.next = headA.next.next.next.next;

        System.out.println("Before :");

        //Arrays.sort();

        var q = new ArrayDeque<Integer>();
        q.stream().mapToInt(i -> i)
                .toArray();



        headA.print();
        headB.print();

        ListNode intersectionNode = getIntersectionNode(headA, headB);
        System.out.println("intersectionNode = " + intersectionNode.val);





    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {


        ListNode curA = headA;
        ListNode curB = headB;

        while(curA != curB) {
            if(curA == null) {
                System.err.println("Switching head A");
               curA = headB;
            } else  {
                System.out.print("curA val = " + curA.val);
                curA = curA.next;
            }

            if(curB == null) {
                System.err.println("Switching head B");
                curB = headA;
                System.out.println();
            } else  {
                System.out.print(" curB val = " + curB.val);
                System.out.println();

                curB = curB.next;
            }
        }

        return curA;
    }



//    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//
//        ListNode reversedA = reverse(headA);
//        ListNode reversedB = reverse(headB);
//
//        ListNode intersect = null;
//
//        ListNode curA = reversedA;
//        ListNode curB = reversedB;
//
//        while(curA != null && curB != null) {
//
//            if(curA.next.val != curB.next.val) {
//                intersect = curA;
//                break;
//            }
//
//            curA = curA.next;
//            curB = curB.next;
//        }
//
//       reverse(reversedA);
//       reverse(reversedB);
//
//
//       return intersect;
//    }
    
    
    private static ListNode reverse(ListNode head) {
        ListNode prev = head;
        ListNode cur = head.next;
        prev.next = null;
        
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            
            prev = cur;
            cur = next;    
        }
        
        return prev; 
    }
    
}