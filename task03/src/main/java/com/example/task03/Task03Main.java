package com.example.task03;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Task03Main
{
    public static void main(String[] args)
    {
        findMinMax(
                Stream.of(2, 9, 5, 4, 8, 1, 3),
                Integer::compareTo,
                (min, max) -> System.out.println("min: " + min + " / max: " + max)
        );

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer)
    {

        if (stream == null)
        {
            throw new NullPointerException("stream is null");
        }
        if (order == null)
        {
            throw new NullPointerException("order is null");
        }
        if (minMaxConsumer == null)
        {
            throw new NullPointerException("minMaxConsumer is null");
        }

        MinMaxFinder<T> finder = new MinMaxFinder<>(order);
        stream.forEach(finder);

        if (finder.found)
        {
            minMaxConsumer.accept(finder.min, finder.max);
        }
        else
        {
            minMaxConsumer.accept(null, null);
        }
    }

    private static class MinMaxFinder<T> implements Consumer<T>
    {
        private final Comparator<? super T> order;
        private T min;
        private T max;
        private boolean found;

        private MinMaxFinder(Comparator<? super T> order)
        {
            this.order = order;
        }

        @Override
        public void accept(T element)
        {
            if (!found)
            {
                min = element;
                max = element;
                found = true;
                return;
            }

            if (order.compare(element, min) < 0)
            {
                min = element;
            }
            if (order.compare(element, max) > 0)
            {
                max = element;
            }
        }
    }
}
