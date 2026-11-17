package com.example.task05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Sendable<T>> {

    private final Map<String, List<T>> mailBox = new MailBox<>();

    @Override
    public void accept(Sendable<T> sendable) {
        mailBox.computeIfAbsent(sendable.getTo(), k -> new ArrayList<>())
               .add(sendable.getContent());
    }

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    // для получателя без писем get() возвращает пустой список, а не null
    private static class MailBox<T> extends HashMap<String, List<T>> {
        @Override
        public List<T> get(Object key) {
            List<T> list = super.get(key);
            return list == null ? Collections.emptyList() : list;
        }
    }
}