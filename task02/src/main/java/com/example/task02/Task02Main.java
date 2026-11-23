package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main
{
    public static void main(String[] args)
    {
        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);
    }

    public static IntStream cycleGrayCode(int n)
    {
        if (n < 1 || n > 16)
        {
            throw new IllegalArgumentException("n " + n + " is not between 1..16");
        }

        int count = 1 << n;

        return IntStream.iterate(0, number -> (number + 1) % count).map(number -> number ^ (number >> 1));
    }
}
