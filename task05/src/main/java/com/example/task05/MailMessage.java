package com.example.task05;

public class MailMessage implements IM<String>{

    private final String from;
    private final String to;

    private final String content;

    public MailMessage(String sender, String consumer, String message) {
        this.from = sender;
        this.to = consumer;
        this.content = message;
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
    public String getContent(){
        return content;
    }

}
