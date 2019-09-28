---
title: factory-method
categories: Creational
---

## Intent
Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.

**Programmatic Example**

Suppose you are the owner of a pizza company at your country. Your company is growing rapidly and you want to open your pizzerias in other countries as well. The problem is that pizza in one country may be different in another, i.e. cheese pizza in Poland uses a completely different cheese than that in Italy and so on.

Your pizzeria offers three different types of pizza: cheese, vegetarian and farm.
```
public enum PizzaType {  
    CHEESE,  
	VEGETARIAN,  
	FARM  
}
```
Each pizza has common attributes: name and description. As we know that we'll define Pizza class as abstract
```
public abstract class Pizza {  
	String name;  
	String description;  
  
	@Override  
	public String toString() {  
	    return "Pizza{" +  
			"name='" + name + '\'' +  
			", description='" + description + '\'' +  
			'}';  
	}
```
Now we can create concrete pizzas as follows
```
class ItalianCheesePizza extends Pizza {  
	ItalianCheesePizza() {  
		this.name = "Italian Cheese Pizza";  
		this.description = "Mozzarella, provolone, monterey jack, cheddar and parmesan";  
	}  
}
```
When all pizza types are created we can start play with our factory
```
class ItalianPizzeriaFactory implements Pizzeria {
	@Override  
	public Pizza make(PizzaType pizzaType) {  
		Pizza pizza;  
		switch (pizzaType) {  
			case CHEESE:  
				pizza = new ItalianCheesePizza();  
				break; 
			case VEGETARIAN:  
				pizza = new ItalianVegetarianPizza();  
				break; 
			case FARM:  
				pizza = new ItalianFarmPizza();  
				break; 
			default:  
				throw new IllegalStateException("No such value in our menu " + pizzaType);  
		}  
		return pizza;  
	}  
}

interface Pizzeria {  
    Pizza make(PizzaType pizzaType);  
}
```
You can create other pizza types and factories in similar way. For brevity I won't paste it here (but you can find it in the code)

Everything is prepared. Let's look how it works
```
Pizzeria italian = new ItalianPizzeriaFactory();  
Pizzeria polish = new PolishPizzeriaFactory();  
  
Pizza cheeseItalianPizza = italian.make(PizzaType.CHEESE);  
Pizza cheesePolishPizza = polish.make(PizzaType.CHEESE);  
  
LOGGER.info("{}", cheeseItalianPizza);  
LOGGER.info("{}", cheesePolishPizza);

// Pizza{name='Italian Cheese Pizza', description='Mozzarella, provolone, monterey jack, cheddar and parmesan'}
// Pizza{name='Polish Cheese Pizza', description='Cheese & Golden Corn'}
```
---
 **Advantages of factory method:**
>Answer taken from [softwareengineering](https://softwareengineering.stackexchange.com/a/200662/311821) - I agree in 100%
* **Reuse.**  If I want to instantiate in many places, I don't have to repeat my condition, so when I come to add a new class, I don't run the risk of missing one.

* **Unit-Testability.**  I can write 3 tests for the factory, to make sure it returns the correct types on the correct conditions, then my calling class only needs to be tested to see if it calls the factory and then the required methods on the returned class. It needs to know nothing about the implementation of the factory itself or the concrete classes.

* **Extensibility.**  When someone decides we need to add a new class D to this factory, none of the calling code, neither unit tests or implementation, ever needs to be told. We simply create a new class D and extend our factory method. This is the very definition of  [Open-Closed Principle](https://en.wikipedia.org/wiki/Open%E2%80%93closed_principle).
