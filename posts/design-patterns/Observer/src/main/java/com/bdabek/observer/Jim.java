package com.bdabek.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Jim implements Observer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Jim.class);
    private GroupChat groupChat;

    Jim(GroupChat groupChat) {
        this.groupChat = groupChat;
        this.groupChat.addObserver(this);
    }

    @Override
    public void update() {
        String message = groupChat.getMessage();
        LOGGER.info("Jim received message: {}", message);
    }

    void writeMessage(String message) {
        LOGGER.info("Jim writes a message: {}", message);
        groupChat.sendMessage(message);
    }

    @Override
    public String toString() {
        return "Jim";
    }
}
