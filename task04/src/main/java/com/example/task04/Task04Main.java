package com.example.task04;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task04Main {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Pattern notLetterOrDigit = Pattern.compile("[^\\p{L}\\p{N}]+");

        reader.lines()
                .map(String::toLowerCase)
                .flatMap(notLetterOrDigit::splitAsStream)
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(word -> System.out.print(word + "\n"));

    }

}
