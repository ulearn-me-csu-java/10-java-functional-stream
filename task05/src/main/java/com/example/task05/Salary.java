package com.example.task05;

import java.util.Objects;

public class Salary implements Sendable<Integer> {
    private final String from;
    private final String to;
    private final Integer content;

    public Salary(String from, String to, Integer content) {
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
    public Integer getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salary salary = (Salary) o;
        return Objects.equals(from, salary.from) &&
                Objects.equals(to, salary.to) &&
                Objects.equals(content, salary.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, content);
    }
}