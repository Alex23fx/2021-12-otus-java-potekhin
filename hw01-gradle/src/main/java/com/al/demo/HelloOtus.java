package com.al.demo;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

public class HelloOtus {

    /**
     * Описание
     * @param args
     */
    public static void main(String... args) {
        System.out.println("Hello OTUS");

        List<Integer> numbers = Lists.newArrayList(1,2,3,4,5,6,7);

        System.out.println(Lists.reverse(numbers));
    }
}
