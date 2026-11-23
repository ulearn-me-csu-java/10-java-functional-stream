package com.example.task03;

import java.util.Comparator;
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

        class MinMax {
            boolean empty = true;
            T min;
            T max;
        }

        MinMax result = stream.collect(
                MinMax::new,
                (r, value) -> {
                    if (r.empty) {
                        r.min = value;
                        r.max = value;
                        r.empty = false;
                    } else {
                        if (order.compare(value, r.min) < 0) {
                            r.min = value;
                        }
                        if (order.compare(value, r.max) > 0) {
                            r.max = value;
                        }
                    }
                },
                (a, b) -> {
                    if (b.empty) return;
                    if (a.empty) {
                        a.min = b.min;
                        a.max = b.max;
                        a.empty = false;
                    } else {
                        if (order.compare(b.min, a.min) < 0) a.min = b.min;
                        if (order.compare(b.max, a.max) > 0) a.max = b.max;
                    }
                }
        );

        if (result.empty) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(result.min, result.max);
        }
    }
}
