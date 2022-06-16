package com.company;

import java.util.stream.Stream;

public class Palindrome {

    public static void main(String[] args) {

        boolean abba = isPalindrome("abbabbba");
        System.out.println("abba = " + abba);

    }

    // abba
    public static boolean isPalindrome(String str) {

        int headIter = 0;
        int tailIter = str.length() - 1;

        while (headIter < str.length()) {
            char head = str.charAt(headIter);
            char tail = str.charAt(tailIter);

            System.out.println("head = " + head);
            System.out.println("tail = " + tail);
            if(head != tail) {
                return false;
            }
            headIter++;
            tailIter--;
        }
       return true;
    }

}
