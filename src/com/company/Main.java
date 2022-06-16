package com.company;

import com.company.Test.Person;

import java.util.Arrays;

public class Main  {

    public Main() {
        System.out.println("main constarustor");
    }
    enum Meal {
        BREAKFAST,
        LUNCH
    }

    public static void main(String[] args) throws CloneNotSupportedException {


        Person person = new Person();





        int[] nums = new int[]{0,1,0,3,12};

        System.out.println("nums = " + Arrays.toString(nums));



        int start = 0;
        int forward = 0;
        int size = nums.length;

        while (forward < size) {
            if (nums[forward] == 0) {
                forward++;
            } else {
                nums[start] = nums[forward];
                start++;
                forward++;
            }
        }
        for (int i=start; i<=size-1; i++)
            nums[i] = 0;

        System.out.println("sorted = " + Arrays.toString(nums));


    }

    public static class Juego extends Main {

        private int value = 0;

        public Juego() {
            value = 5;
            System.out.println("juego contutor ");
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
           // Object clone = super.clone();
            return new Juego();
           // Arrays.sort
        }

    }




}
