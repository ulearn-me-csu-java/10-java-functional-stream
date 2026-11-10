package com.example.task02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.StrictMath.pow;

public class Task02Main {

    public static void main(String[] args) {


        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);


    }

    public static IntStream cycleGrayCode(int n) {

        if (n < 1 || n > 16) {
            throw new IllegalArgumentException();
        }

        int size = 1 << n;
        int[] codes = new int[size];

        for (int i = 0; i < size; i++) {
            codes[i] = i ^ (i >>> 1);
        }

        return IntStream.iterate(0, i -> (i + 1) % size)
                .map(i -> codes[i]);
    }

}
