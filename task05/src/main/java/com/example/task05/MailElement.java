package com.example.task05;

public interface MailElement<T> {
    String getTo();
    T getContent();
}
