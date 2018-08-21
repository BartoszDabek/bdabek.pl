package com.bdabek.command.commands;

import com.bdabek.command.ElectronicDevice;

public class TurnDeviceOff implements Command {

    private ElectronicDevice device;

    public TurnDeviceOff(ElectronicDevice device) {
        this.device = device;
    }

    public void execute() {
        device.off();
    }

    public void unexecute() {
        device.on();
    }
}
