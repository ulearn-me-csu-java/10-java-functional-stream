package com.example.task05;

public class Salary extends BaseMessage<Integer> {

    public Salary(String from, String to, Integer salary) {
        super(from, to, salary);
    }

    public Integer getSalary() {
        return getContent();
    }
}
