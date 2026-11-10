package com.example.task05;


import java.util.*;
import java.util.function.Consumer;

public class mailService<T> implements Consumer<IM<T>>{

    private final Map<String, List<T>> mailBox = new HashMap<String, List<T>>() {
        @Override
        public List<T> get(Object key) {
            return containsKey(key) ? super.get(key) : Collections.emptyList();
        }
    };

    @Override
    public void accept(IM<T> sendable) {
        mailBox.computeIfAbsent(sendable.getTo(), k -> new ArrayList<>()).add(sendable.getContent());
    }

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }
}
