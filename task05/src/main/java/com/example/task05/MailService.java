package com.example.task05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<ISendable<T>> {

    // Для получателя, которому ничего не отправляли, get вернёт пустой список, а не null
    private final Map<String, List<T>> mailBox = new HashMap<>() {
        @Override
        public List<T> get(Object key) {
            return super.getOrDefault(key, Collections.emptyList());
        }
    };

    @Override
    public void accept(ISendable<T> item) {
        mailBox.computeIfAbsent(item.getTo(), k -> new ArrayList<>())
                .add(item.getContent());
    }

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }
}