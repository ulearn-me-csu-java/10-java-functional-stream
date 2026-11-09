package com.example.task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task04Main {

    private static final Pattern WORD_PATTERN =
            Pattern.compile("[\\p{L}\\p{Nd}]+", Pattern.UNICODE_CHARACTER_CLASS);

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8))) {

            Map<String, Long> wordFrequency = reader.lines()
                    .flatMap(line -> WORD_PATTERN.matcher(line).results()
                            .map(match -> match.group().toLowerCase(Locale.ROOT)))
                    .collect(Collectors.groupingBy(
                            Function.identity(),
                            Collectors.counting()));

            System.out.print(
                    wordFrequency.entrySet().stream()
                            .sorted(Comparator
                                    .<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue).reversed()
                                    .thenComparing(Map.Entry::getKey))
                            .limit(10)
                            .map(Map.Entry::getKey)
                            .collect(Collectors.joining("\n"))
            );
        }
    }
}