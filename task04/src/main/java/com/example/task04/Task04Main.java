package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task04Main {

    public static void main(String[] args) {
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))
                .lines()
                .flatMap(line -> Arrays.stream(line.split("[^\\p{L}\\p{Digit}]+")))
                .map(String::toLowerCase)
                .filter(w -> !w.isEmpty())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue).reversed()
                        .thenComparing(Map.Entry::getKey))
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(w -> System.out.print(w + "\n"));
    }

}
