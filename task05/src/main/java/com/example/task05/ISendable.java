package com.example.task05;

public interface ISendable<T> {
    String getFrom();
    String getTo();
    T getContent();
}