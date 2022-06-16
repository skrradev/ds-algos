package com.company;

import java.util.HashMap;

public class RomanNumbers {
    public static void main(String[] args) {
        int mcmxciv = romanToInt("XIV");
        System.out.println("mcmxciv = " + mcmxciv);

    }


    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        for(int i=0; i<s.length()-1; i++){
            int curr = map.get(s.charAt(i));
            int next = map.get(s.charAt(i+1));
            res = curr < next ? res - curr : res + curr;
        }
        return  res + map.get(s.charAt(s.length()-1));
    }


    //
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000
    public static int romanToInt2(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'I') {
                if(i+1 < s.length()) {
                    if (s.charAt(i+1) == 'X') {
                        sum = sum + 9;
                        i++;
                        continue;
                    }
                    if (s.charAt(i+1) == 'V') {
                        sum = sum + 4;
                        i++;
                        continue;
                    }

                }
                sum = sum + 1;
            }
            if(s.charAt(i) == 'V') {
                sum = sum + 5;
            }
            if(s.charAt(i) == 'X') {
                if(i+1 < s.length()) {
                    if (s.charAt(i+1) == 'L') {
                        sum = sum + 40;
                        i++;
                        continue;
                    }
                    if (s.charAt(i+1) == 'C') {
                        sum = sum + 90;
                        i++;
                        continue;
                    }

                }
                sum = sum + 10;
            }
            if(s.charAt(i) == 'L') {
                sum = sum + 50;
            }
            if(s.charAt(i) == 'C') {
                if(i+1 < s.length()) {
                    if (s.charAt(i+1) == 'D') {
                        sum = sum + 400;
                        i++;
                        continue;
                    }
                    if (s.charAt(i+1) == 'M') {
                        sum = sum + 900;
                        i++;
                        continue;
                    }

                }



                sum = sum + 100;
            }
            if(s.charAt(i) == 'D') {
                sum = sum + 500;
            }
            if(s.charAt(i) == 'M') {
                sum = sum + 1000;
            }

        }

        return sum;

    }
}
