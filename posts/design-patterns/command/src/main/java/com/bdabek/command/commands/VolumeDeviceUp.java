package com.bdabek.command.commands;

import com.bdabek.command.ElectronicDevice;

public class VolumeDeviceUp implements Command {

    private ElectronicDevice device;

    public VolumeDeviceUp(ElectronicDevice device) {
        this.device = device;
    }

    public void execute() {
        device.volumeUp();
    }

    public void unexecute() {
        device.volumeDown();
    }
}
