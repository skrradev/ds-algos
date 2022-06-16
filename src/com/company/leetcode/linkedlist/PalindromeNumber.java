package com.company.leetcode.linkedlist;

public class PalindromeNumber {
    public static void main(String[] args) {

        System.out.println(isPalindrome(122231));

    }

    public static boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x !=0)) {
            return false;
        }

        int number = x;
        int reverted = 0;

        while (number > 0) {
            int n = reverted * 10 ;
            reverted = n + number % 10;

            number = number / 10;
        }
        System.out.println("reverted = " + reverted);

        return reverted == x;
    }
}
