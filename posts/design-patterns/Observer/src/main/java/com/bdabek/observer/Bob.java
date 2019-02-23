package com.bdabek.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Bob implements Observer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Bob.class);
    private GroupChat groupChat;

    Bob(GroupChat groupChat) {
        this.groupChat = groupChat;
        this.groupChat.addObserver(this);
    }

    @Override
    public void update() {
        String message = groupChat.getMessage();
        LOGGER.info("Bob received message: {}", message);
    }

    void writeMessage(String message) {
        LOGGER.info("Bob writes a message: {}", message);
        groupChat.sendMessage(message);
    }

    @Override
    public String toString() {
        return "Bob";
    }
}
