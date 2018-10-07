package com.bdabek.command;

import com.bdabek.command.commands.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    private ElectronicDevice device;
    private RemoteController onPress;

    @BeforeEach
    void init() {
        device = new Computer();

        Command deviceOn = new TurnDeviceOn(device);
        Command deviceOff = new TurnDeviceOff(device);
        Command deviceUp = new VolumeDeviceUp(device);
        Command deviceDown = new VolumeDeviceDown(device);

        onPress = new RemoteController(deviceOn, deviceOff, deviceUp, deviceDown);
    }

    @Test
    void shouldBeTurnedOffWhenNothingInvoked() {
        assertFalse(((Computer) device).isTurned());
    }

    @Test
    void shouldTurnOnWhenPressInvoked() {
        onPress.pressOn();
        assertTrue(((Computer) device).isTurned());
    }

    @Test
    void shouldVolumeUpWhenPressInvoked() {
        onPress.pressUp();
        onPress.pressUp();
        onPress.pressUp();

        assertEquals(3, ((Computer) device).getVolume());
    }

    @Test
    void shouldVolumeDownWhenPressInvoked() {
        onPress.pressUp();
        onPress.pressUp();
        onPress.pressUp();
        onPress.pressDown();

        assertEquals(2, ((Computer) device).getVolume());
    }

    @Test
    void shouldTurnOffAfterTurnOnWhenPressInvoked() {
        onPress.pressOn();
        onPress.pressOff();

        assertFalse(((Computer) device).isTurned());
    }
}