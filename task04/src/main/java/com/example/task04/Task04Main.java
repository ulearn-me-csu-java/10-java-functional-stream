package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class Task04Main
{
    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Map<String, Long> frequencies = reader.lines()
                .flatMap(line -> Arrays.stream(line.split("[^\\p{L}\\p{N}]+")))
                .filter(word -> !word.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        frequencies.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry<String, Long>::getValue)
                        .reversed()
                        .thenComparing(Map.Entry::getKey))
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(word -> System.out.print(word + "\n"));

        System.out.flush();
    }
}
