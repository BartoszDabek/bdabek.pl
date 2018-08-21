---
layout: pattern
title: Command
categories: Behavioral
---

## Intent
Encapsulate a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.

## Explanation
Consider the following example. You have one remote control and you want to turn on/off, volume up/down several devices with this particular remote only. In our example let it be a TV and a computer. 
The TV and the computer are receivers.

So, firstly let's define interface for our receivers, call it `ElectronicDevice`. It's very simple

```
public interface ElectronicDevice {  
    void on();  
    void off();  
    void volumeUp();  
    void volumeDown();  
}

```
Now we have to implement each of receivers... (we'll omit Computer class implementation for readability because it's basically the same)

```
public class TV implements ElectronicDevice {  

    // ... declarations omitted for brevity
	
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
	
    // getters
}

```
Good! We have implemented our receivers now we need to define interface for our commands which is very straightfull, it simply defines two methods: execute and unexecute. 

```
public interface Command {  
    void execute();  
    void unexecute();  
}
```
And now, when we have `Command` interface defined, we can implement each of commands. 

#### What those commands should look like?
It's very simple! Each command have each responsibility! So in our example we should have at least four different commands: 
- turn on
- turn off
- volume up
- volume down 

Let's see how the implementation looks like. We'll take a look at `Turn on command` 
```
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
```
As you can see, constructor takes ElectronicDevice as a parameter and assigns it to instance variable. So you can inject either Computer or TV class. In the future if you'll add a new class that implements `ElectronicDevice`, you can use it too!

So how is looking `Turn off command`? Very similar!! Actually the same, the only difference is that now, execute command turning device off and unexecute - turning device on.
```
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
```
And as you can guess, the same happens with volume up and down. We'll omit it for brevity (you can find it out in /src).

Okay! We have receivers, all commands are set and ready, the only piece that missing is someone who's invoking it. In our example let it be a `RemoteController`, because that makes sense. You can control your TV and a computer with a remote. In command design pattern `RemoteController` is called - <b>Invoker</b>. 

Invoker can have different implementations. In our case it looks as following:
```
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
```
The constructor takes 4 parameters. Each of them is responsible for concrete command. Now you can imagine this remote control as a remote control with 6 buttons:
1. Turn on
2. Turn off
3. Volume up
4. Volume down
5. History back
6. History redo

And that's all. Now client can freely take the remote and pressing buttons
```
RemoteController onPress = getRemoteController(new TV());  
onPress.pressOn();  // TV is on
onPress.pressUp();  // TV volume: 1
onPress.pressUp();  // TV volume: 2
onPress.pressUp();  // TV volume: 3
onPress.pressDown();  // TV volume: 2
onPress.pressOff();  // TV is off
  
onPress.undoHistory();  // TV is on
onPress.undoHistory();  // TV volume: 3
onPress.redoHistory();  // TV volume: 2
onPress.redoHistory();  // TV is off
```
Where `getRemoteController` is a static method which sets each button
```
private static RemoteController getRemoteController(ElectronicDevice device) {  
    Command deviceOn = new TurnDeviceOn(device);  
    Command deviceOff = new TurnDeviceOff(device);  
    Command deviceUp = new VolumeDeviceUp(device);  
    Command deviceDown = new VolumeDeviceDown(device);  

    return new RemoteController(deviceOn, deviceOff, deviceUp, deviceDown);  
}
```
Undo, redo operations are implemented as a simple stack. (I'm sure it can be done in more efficient way - but it's not the point here).

---
That's all!
Hope that it made it more clear for you. 💪💪 

Ciaoo!
