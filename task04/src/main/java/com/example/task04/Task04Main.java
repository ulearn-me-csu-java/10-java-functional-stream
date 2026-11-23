package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task04Main {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[\\p{L}\\p{N}]+");

        System.out.print(
                new BufferedReader(
                        new InputStreamReader(System.in, StandardCharsets.UTF_8)
                )
                        .lines()
                        .flatMap(line -> pattern.matcher(line.toLowerCase(Locale.ROOT))
                                .results()
                                .map(match -> match.group()))
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        ))
                        .entrySet()
                        .stream()
                        .sorted(
                                Map.Entry.<String, Long>comparingByValue(
                                        Comparator.reverseOrder()
                                ).thenComparing(Map.Entry.comparingByKey())
                        )
                        .limit(10)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.joining("\n"))
        );
    }
}
