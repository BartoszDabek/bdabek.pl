package com.bdabek.command;

import com.bdabek.command.commands.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoteControllerUndoRedoTest {

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
    void shouldVolumeDownWhenUndoHistory() {
        onPress.pressUp();
        onPress.pressUp();
        onPress.pressUp();

        onPress.undoHistory();
        onPress.undoHistory();

        assertEquals(1, ((Computer) device).getVolume());
    }

    @Test
    void shouldTurnOnAndSetCorrectVolumeWhenUndoRedoHistory() {
        onPress.pressOn();
        onPress.pressUp();
        onPress.pressUp();
        onPress.pressOff();

        onPress.undoHistory();
        onPress.undoHistory();
        onPress.redoHistory();

        assertTrue(((Computer) device).isTurned());
        assertEquals(2, ((Computer) device).getVolume());
    }

    @Test
    void shouldSetCorrectVolumeWhenUndoAndRedoHistory() {
        onPress.pressUp();

        onPress.undoHistory();
        onPress.redoHistory();

        assertEquals(1, ((Computer) device).getVolume());
    }

    @Test
    void shouldSetCorrectVolumeWhenPressUpExecutedAfterUndoHistory() {
        onPress.pressUp();
        onPress.pressUp();
        onPress.pressUp();

        onPress.undoHistory();
        onPress.undoHistory();

        onPress.pressUp();
        onPress.redoHistory();

        assertEquals(3, ((Computer) device).getVolume());
    }
}