package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.print(node.data);

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
    }


    /*
     * Complete the 'reversePrint' function below.
     *
     * The function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static void reversePrint(SinglyLinkedListNode llist) {
        if(llist == null) {
            return;
        }
        
       SinglyLinkedListNode cur = llist;
       int size = 0;
       while(cur != null) {
           cur = cur.next;
           size++;
       } 
       int[] array = new int[size];
       
         cur = llist;
        int index = 0;
       while(cur != null) {
           array[index] = cur.data;
           cur = cur.next;
           index++;
       } 
       
       for(int i = array.length-1; i >= 0; i--) {
           System.out.println(array[i]);
       }
        

    }

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        SinglyLinkedListNode prev = llist;
        SinglyLinkedListNode cur = llist.next;
        SinglyLinkedListNode last = llist;
        last.next = null;
        while (cur != null) {
            SinglyLinkedListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        int tests = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int testsItr = 0; testsItr < tests; testsItr++) {
//            SinglyLinkedList llist = new SinglyLinkedList();
//
//            int llistCount = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int i = 0; i < llistCount; i++) {
//                int llistItem = scanner.nextInt();
//                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//                llist.insertNode(llistItem);
//            }
//
//            reversePrint(llist.head);
//        }
//
//        scanner.close();
        SinglyLinkedList llist = new SinglyLinkedList();

        llist.insertNode(6);
        llist.insertNode(7);
        llist.insertNode(8);
        llist.insertNode(9);
        llist.insertNode(10);


        SinglyLinkedListNode reverse = reverse(llist.head);

        printSinglyLinkedList(reverse, " ");

    }
}
