package com.example.task05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Sendable<T>>
{
    private final Map<String, List<T>> mailBox = new MailBoxMap<>();

    public Map<String, List<T>> getMailBox()
    {
        return mailBox;
    }

    @Override
    public void accept(Sendable<T> item)
    {
        String recipient = item.getTo();
        List<T> items;
        if (mailBox.containsKey(recipient))
        {
            items = mailBox.get(recipient);
        }
        else
        {
            items = new ArrayList<>();
            mailBox.put(recipient, items);
        }
        items.add(item.getContent());
    }

    private static class MailBoxMap<T> extends HashMap<String, List<T>>
    {
        @Override
        public List<T> get(Object key)
        {
            List<T> items = super.get(key);
            return items == null ? Collections.emptyList() : items;
        }
    }
}