package com.bdabek.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TV implements ElectronicDevice {

    private static final Logger logger = LoggerFactory.getLogger(TV.class);
    private int volume = 0;
    private boolean turned;

    public void on() {
        turned = true;
        logger.info("TV is on");
    }

    public void off() {
        turned = false;
        logger.info("TV is off");
    }

    public void volumeUp() {
        volume++;
        logger.info("TV volume: " + volume);
    }

    public void volumeDown() {
        volume--;
        logger.info("TV volume: " + volume);
    }

    int getVolume() {
        return volume;
    }

    boolean isTurned() {
        return turned;
    }
}
