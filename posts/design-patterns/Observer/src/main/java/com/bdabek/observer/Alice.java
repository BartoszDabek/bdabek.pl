package com.bdabek.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Alice implements Observer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Alice.class);
    private GroupChat groupChat;

    Alice(GroupChat groupChat) {
        this.groupChat = groupChat;
        this.groupChat.addObserver(this);
    }

    @Override
    public void update() {
        String message = groupChat.getMessage();
        LOGGER.info("Alice received message: {}", message);}

    void writeMessage(String message) {
        LOGGER.info("Alice writes a message: {}", message);
        groupChat.sendMessage(message);
    }

    @Override
    public String toString() {
        return "Alice";
    }
}
