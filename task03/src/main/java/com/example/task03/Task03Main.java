package com.example.task03;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Task03Main {

    public static void main(String[] args) {

        findMinMax(
                Stream.of(2, 9, 5, 4, 8, 1, 3),
                Integer::compareTo,
                (min, max) ->
                        System.out.println("min: " + min + " / max: " + max)
        );

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        Objects.requireNonNull(stream);
        Objects.requireNonNull(order);
        Objects.requireNonNull(minMaxConsumer);

        MinMax<T> result = new MinMax<>();

        stream.forEach(item -> {
            if (result.empty) {
                result.min = item;
                result.max = item;
                result.empty = false;
            } else {
                if (order.compare(item, result.min) < 0) {
                    result.min = item;
                }
                if (order.compare(item, result.max) > 0) {
                    result.max = item;
                }
            }
        });

        minMaxConsumer.accept(result.min, result.max);
    }

    private static class MinMax<T> {
        T min;
        T max;
        boolean empty = true;
    }
}