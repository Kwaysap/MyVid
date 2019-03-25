package com.example.myvid;

public class MessageEvent {

    public String message;

    // Constructor that takes a message as a parameter,
    // the message is passed from one fragment to the other
    // using EventBus
    public MessageEvent(String message) {
        this.message = message;
    }
}
