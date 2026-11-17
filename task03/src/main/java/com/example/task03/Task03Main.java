package com.example.task03;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;
import java.util.Iterator;

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

    Iterator<? extends T> it = stream.iterator();
    if (!it.hasNext()) {
        minMaxConsumer.accept(null, null);
        return;
    }

    T min = it.next();
    T max = min;
    while (it.hasNext()) {
        T item = it.next();
        if (order.compare(item, min) < 0) min = item;
        if (order.compare(item, max) > 0) max = item;
    }
    minMaxConsumer.accept(min, max);
    }
}
