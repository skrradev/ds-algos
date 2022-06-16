package com.company;

public class ReverseInt {

    public static void main(String[] args) {
        int i =
                rankNumbers(123);
        System.out.println("i = " + i);
    }

    /**
     * Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
     */

    static int divider = 10;
    static int realNumber = 0;

    // 123
    // 120  3
    // 12
    public static int rankNumbers(int number) {
        if (number == 0)
            return realNumber;

        int digit = number % 10;
        realNumber = realNumber * 10 + digit;
        number = number/10;
        return rankNumbers(number);
    }

}
