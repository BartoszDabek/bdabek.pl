package com.bdabek.command.commands;

import com.bdabek.command.ElectronicDevice;

public class VolumeDeviceDown implements Command {

    private ElectronicDevice device;

    public VolumeDeviceDown(ElectronicDevice device) {
        this.device = device;
    }

    public void execute() {
        device.volumeDown();
    }

    public void unexecute() {
        device.volumeUp();
    }
}
