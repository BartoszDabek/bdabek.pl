package com.bdabek.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GroupChat implements Observable {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupChat.class);
    private List<Observer> observers;
    private String message;

    public GroupChat() {
        LOGGER.info("Group chat is created");
        observers = new ArrayList<>();
    }

    public String getMessage() {
        return message;
    }

    public void sendMessage(String message) {
        this.message = message;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        LOGGER.info("{} added to the group", observer);
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        LOGGER.info("{} left the group", observer);
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        this.observers.forEach(Observer::update);
    }
}
