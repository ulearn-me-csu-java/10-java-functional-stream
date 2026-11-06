package com.example.task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class Task04Main {

    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))){
            Map<String, Long> frequencyMap = br.lines()
                    .flatMap(line -> Arrays.stream(line.split("[^a-zA-Zа-яА-ЯёЁ0-9]+")))
                    .map(String::toLowerCase)
                    .filter(word -> !word.isEmpty())
                    .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
            frequencyMap.entrySet().stream()
                    .sorted(
                            Comparator.comparing(Map.Entry<String, Long>::getValue, Comparator.reverseOrder())
                                    .thenComparing(Map.Entry::getKey)
                    )
                    .limit(10)
                    .forEach(entry -> System.out.print(entry.getKey() + "\n"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
