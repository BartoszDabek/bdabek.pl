package com.bdabek.command;

import com.bdabek.command.commands.*;

public class Robert {

    public static void main(String[] args) {
        RemoteController onPress = getRemoteController(new TV());
        onPress.pressOn();
        onPress.pressUp();
        onPress.pressUp();
        onPress.pressUp();
        onPress.pressDown();
        onPress.pressOff();

        onPress.undoHistory();
        onPress.undoHistory();
        onPress.redoHistory();
        onPress.redoHistory();
    }

    private static RemoteController getRemoteController(ElectronicDevice device) {
        Command deviceOn = new TurnDeviceOn(device);
        Command deviceOff = new TurnDeviceOff(device);
        Command deviceUp = new VolumeDeviceUp(device);
        Command deviceDown = new VolumeDeviceDown(device);

        return new RemoteController(deviceOn, deviceOff, deviceUp, deviceDown);
    }
}
