package com.example.task05;

import java.util.Objects;

public abstract class BaseMessage<T> implements Sendable<T> {

    private final String from;
    private final String to;
    private final T content;

    public BaseMessage(String from, String to, T content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public T getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseMessage<?> that = (BaseMessage<?>) o;
        return Objects.equals(from, that.from) &&
                Objects.equals(to, that.to) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, content);
    }
}
