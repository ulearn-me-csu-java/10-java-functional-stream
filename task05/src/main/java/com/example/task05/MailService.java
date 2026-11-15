package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<MailElement<T>> {
    private final Map<String, List<T>> mailBox = new HashMap<>();

    public Map<String, List<T>> getMailBox() {
        return new HashMap<String, List<T>>(mailBox) {
            @Override
            public List<T> get(Object key) {
                List<T> list = super.get(key);
                // Если список null (ключа нет), возвращаем пустой список
                return list == null ? Collections.emptyList() : list;
            }
        };
    }

    @Override
    public void accept(MailElement<T> element){
        String name_to = element.getTo();
        T content = element.getContent();

        if (!mailBox.containsKey(name_to)) {
            mailBox.put(name_to, new ArrayList<>());
        }
        mailBox.get(name_to).add(content);

    }
}
