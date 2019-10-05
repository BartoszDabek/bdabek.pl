---
title: abstract-factory
categories: Creational
---

## Intent
Provide an interface for creating families of related or dependent objects without specifying their concrete classes.

**Programmatic Example**

I hope you are familiar with the game - League of Legends, if so then this example will be great for you. In this game you have a map - on which you play. The map is divided into different areas - nexus, forest, lane (including towers and minions). Now suppose that you want to add a new feature that changes the map UI. Suppose winter is coming and you want to change the entire map to support winter layout. Ofc. when winter is over you want to restore the map to the standard layout. Or maybe you want to create a two-week event that will be annual and during these 2 weeks you want to change the map layout to something else. **To solve this problem in an elegant way you can use Abstract Factory to help you solve all the problems!**

OK! Let's begin.. First of all, we want to define and implement model interfaces
```
public interface Forest {  
    void buildForest();  
}
public interface Lane {  
    void buildLane();  
}
public interface Nexus {  
    void buildNexus();  
}

// Standard implementations
public class StandardForest implements Forest {  
	@Override  
	public void buildForest() {  
	    log.debug("Building Standard Forest");  
	}  
}
public class StandardLane implements Lane {  
	@Override  
	public void buildLane() {  
		log.debug("Building Standard Lane");  
	}  
}
public class StandardNexus implements Nexus {  
	@Override  
	public void buildNexus() {  
		log.debug("Building Standard Nexus");  
	}  
}

// Winter or any other implementation similarly...
```
Then we have the abstraction and implementations for the map factory
```
public interface MapFactory {  
	Nexus createNexus();  
	Forest createForest();  
	Lane createLane();  
}

public class StandardMapFactory implements MapFactory {  
	@Override  
	public Nexus createNexus() {  
		return new StandardNexus();  
	}  
	@Override  
	public Forest createForest() {  
		return new StandardForest();  
	}  
	@Override  
	public Lane createLane() {  
		return new StandardLane();  
	}  
}

public class WinterMapFactory implements MapFactory {  
	@Override  
	public Nexus createNexus() {  
		return new WinterNexus();  
	}  
	@Override  
	public Forest createForest() {  
		return new WinterForest();  
	}  
	@Override  
	public Lane createLane() {  
		return new WinterLane();  
	}  
}
```
Now we have our abstract factory that lets us make family of related objects i.e. Standard map factory creates Standard nexus, forest and lane etc.
```
MapFactory factory = new StandardMapFactory();  
factory.createLane().buildLane(); // Building Standard Lane  
factory.createNexus().buildNexus(); // Building Standard Nexus  
factory.createForest().buildForest(); // Building Standard Forest
```
Now, we can design a factory for our different map factories. In this example, we created FactoryMaker,
The client can use FactoryMaker to create the desired concrete factory which, in turn, will produce different concrete objects (Nexus, Forest, Lane).  
In this example, we also used an enum to parameterize which type of map factory the client will ask for.
```
public static class FactoryMaker {  
	public enum MapType {  
		STANDARD, WINTER
	}  

	static MapFactory makeFactory(MapType type) {  
		return switch (type) {  
			case STANDARD -> new StandardMapFactory();  
			case WINTER -> new WinterMapFactory();  
		};  
	}  
}

public static void main(String[] args) {  
	App app = new App();  
	app.createMap(FactoryMaker.makeFactory(FactoryMaker.MapType.STANDARD));  
	app.createMap(FactoryMaker.makeFactory(FactoryMaker.MapType.WINTER));  
}

private void createMap(final MapFactory factory) {  
	factory.createNexus().buildNexus();  
	factory.createForest().buildForest();  
	factory.createLane().buildLane();  
}
```
Now, if you want to create new completely different map you can do it very easily! All you need is to create new models e.g. Magical. Then you create new factory and that's all. **No modifying** existing code - all you do is **extending**! You can find more abstract factory examples in the code - go for it 😉!
