package com.bdabek.command;

import com.bdabek.command.commands.Command;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoteController {

    private Deque<Command> history;
    private Command on;
    private Command off;
    private Command up;
    private Command down;

    public RemoteController(Command on, Command off, Command up, Command down) {
        this.on = on;
        this.off = off;
        this.up = up;
        this.down = down;
        history = new ArrayDeque<>();
    }

    public void pressOn() {
        on.execute();
        history.add(on);
    }

    public void pressOff() {
        off.execute();
        history.add(off);
    }

    public void pressUp() {
        up.execute();
        history.add(up);
    }

    public void pressDown() {
        down.execute();
        history.add(down);
    }

    public void undoHistory() {
        history.getLast().unexecute();
        Command pop = history.pollLast();
        history.push(pop);
    }

    public void redoHistory() {
        history.getFirst().execute();
        Command poll = history.pollFirst();
        history.add(poll);
    }
}
