package com.bdabek.command.commands;

import com.bdabek.command.ElectronicDevice;

public class TurnDeviceOn implements Command {

    private ElectronicDevice device;

    public TurnDeviceOn(ElectronicDevice device) {
        this.device = device;
    }

    public void execute() {
        device.on();
    }

    public void unexecute() {
        device.off();
    }
}
