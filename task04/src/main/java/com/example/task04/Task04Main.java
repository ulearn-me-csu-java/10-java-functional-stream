package com.example.task04;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Task04Main {

    public static void main(String[] args) {

        Scanner inStream = new Scanner(System.in, StandardCharsets.UTF_8);
        inStream.useDelimiter("[^\\p{L}\\p{Nd}]+");

        Map<String, Integer> dict = new HashMap<>();

        while (inStream.hasNext()){

            String token = inStream.next().toLowerCase();

            dict.merge(token,1,Integer::sum);

            }

        List<Map.Entry<String,Integer>> listWords = dict.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()).
                        thenComparing(Map.Entry.comparingByKey())).limit(10).toList();

        listWords.forEach(element -> System.out.print(element.getKey() + "\n"));

        }
    }
