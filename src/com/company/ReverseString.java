package com.company;

import java.util.Arrays;
import java.util.function.BiFunction;

public class ReverseString {

    public static void main(String[] args) {
        String[] split = "abcdf".split("");
        System.out.println("split = " + Arrays.toString(split));



//         Arrays.stream(split)
//                .reduce(new StringBuilder(), new BiFunction<StringBuilder, String, StringBuilder>() {
//                    @Override
//                    public StringBuilder apply(StringBuilder stringBuilder, String s) {
//                        return null;
//                    }
//                });
//
//        System.out.println("reduce = " + reduce);


    }
}
