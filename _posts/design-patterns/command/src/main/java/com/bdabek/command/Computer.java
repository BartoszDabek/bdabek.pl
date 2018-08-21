package com.bdabek.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Computer implements ElectronicDevice {

    private static final Logger logger = LoggerFactory.getLogger(Computer.class);
    private int volume = 0;
    private boolean turned;

    public void on() {
        turned = true;
        logger.info("Computer is on");
    }

    public void off() {
        turned = false;
        logger.info("Computer is off");
    }

    public void volumeUp() {
        volume++;
        logger.info("Computer volume: " + volume);
    }

    public void volumeDown() {
        volume--;
        logger.info("Computer volume: " + volume);
    }

    int getVolume() {
        return volume;
    }

    boolean isTurned() {
        return turned;
    }
}
