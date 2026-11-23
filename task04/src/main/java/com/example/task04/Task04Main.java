package com.example.task04;

import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task04Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        // Разделитель — любой символ, НЕ являющийся буквой или цифрой
        scanner.useDelimiter("[^\\p{L}\\p{Digit}]+");

        scanner.tokens()
                .map(String::toLowerCase)
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(
                        Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                                .thenComparing(Map.Entry.comparingByKey())
                )
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(word -> System.out.print(word + "\n"));
    }
}