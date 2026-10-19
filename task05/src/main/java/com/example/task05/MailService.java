package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Sendable<T>> {

    private final Map<String, List<T>> mailBox = new LinkedHashMap<String, List<T>>() {
        @Override
        public List<T> get(Object key) {
            List<T> list = super.get(key);
            return list != null ? list : Collections.emptyList();
        }
    };

    @Override
    public void accept(Sendable<T> item) {
        mailBox.computeIfAbsent(item.getTo(), k -> new ArrayList<>()).add(item.getContent());
    }

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }
}
