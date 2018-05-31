---
layout: pattern
title: Decorator
categories: Structural
---

## Intent
Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.

## Explanation

*Example*
> We all have computers. We use the power button to turn it on and off and we don't even know what's happens underneath. In fact there is some magic which enables/disables all necessary system things but we don't really care about these things, we just want to see the final result. <br><center>**The on/off button is facade in this example.**</center>

*In plain words*
> Facade pattern provides a simplified interface to a complex subsystem.

**Programmatic Example**

Taking our computer example from above. Here we have very simplified abstract things that happen when starting / shutting down the computer.

```  
interface SystemInterface {  
    fun powerPress()  
    fun greetTheUser()  
    fun interactWithUser()  
}


class SystemOff : SystemInterface {  
  
	override fun interactWithUser() {  
		logger.info { "Press ESC to continue.." }  
	}  
  
	override fun powerPress() {  
		closePrograms()  
		logOutUser()  
	}  
  
    override fun greetTheUser() {  
        logger.info { "Bye bye!" }  
    }  
  
    private fun closePrograms() {  
        logger.info { "Programs closed" }  
    }  
  
    private fun logOutUser() {  
        logger.info { "User logged out" }  
    }  
}


class SystemOn : SystemInterface {  

    override fun interactWithUser() {  
        logger.info { "You need to press ENTER to continue.. LOGGER " }  
    }  
  
    override fun powerPress() {  
        systemStartUp()  
        logInUser()  
    }  
  
    override fun greetTheUser() {  
        logger.info { "Welcome in the system!" }  
    }  
  
    private fun systemStartUp() {  
        logger.info { "BIOS started" }  
    }  
  
    private fun logInUser() {  
        logger.info { "User logged in" }  
    }  
}
```
And here comes our todays hero. Facade!
```
class SystemFacade {    
    fun powerOn() {  
        val systemOn = SystemOn()  
        systemOn.interactWithUser()  
        systemOn.powerPress()  
        systemOn.greetTheUser()  
    }  
  
    fun powerOff() {  
        val systemOff = SystemOff()  
        systemOff.interactWithUser()  
        systemOff.powerPress()  
        systemOff.greetTheUser()  
    }  
}
```
Now in order to turn on/off computer we don't need to know that:
1. We should interact with user 
2. We should run BIOS
3. ... 

It's much more easier, we just need to call powerOn/Off method on SystemFacade and that is all!
To use the facade:
```  
val facade = SystemFacade()  
facade.powerOn()  
// You need to press ENTER to continue.. LOGGER 
// BIOS started
// User logged in
// Welcome in the system!
facade.powerOff()  
// Press ESC to continue..
// Programs closed
// User logged out
// Bye bye!
```

## Private notes
I know it is very trivial example but in general it shows what is facade intent and how we can use the pattern. In real programming world you can see that huge frameworks using it (Spring/Loggers).
 
Facade pattern is very useful and allows you to use solutions without deep root/dependencies knowledge. Sometimes you'll have to dive into it .. but for general purpose there is always a convenient way.

___
Have a good day :)   