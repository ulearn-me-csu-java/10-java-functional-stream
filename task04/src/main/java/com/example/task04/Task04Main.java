package com.example.task04;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task04Main {

    public static void main(String[] args) {
        new Scanner(System.in, "UTF-8")
                .useDelimiter("\\A")
                .tokens()
                .flatMap(text -> Arrays.stream(
                        text.toLowerCase(Locale.ROOT)
                                .split("[^\\p{L}\\p{N}]+")
                ))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(
                        Map.Entry.<String, Long>comparingByValue()
                                .reversed()
                                .thenComparing(Map.Entry.comparingByKey())
                )
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining("\n"))
                .transform(result -> result.isEmpty() ? "" : result + "\n")
                .describeConstable()
                .ifPresent(System.out::print);
    }

}
