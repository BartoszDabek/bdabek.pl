---
layout: pattern
title: Decorator
categories: Structural
---


## Intent
Attach additional responsibilities to an object dynamically. 
Decorators are flexible alternative of subclassing.

## Explanation

Real world example

> Consider a case of a pizza shop where we don't have pizza's menu! All we have is a <b>basic pizza</b> that only has a dough. Basic pizza has it's own price and some description. If we want something more to this pizza we need to order it as extras. For example we can order double cheese, extra chilli, pepperoni etc.... <br> 
> <center><h3>All those extras orders are decorators in our example!</h3> </center>

**Programmatic Example**

Let's take the pizza example. First of all we have a base pizza implementing the pizza interface.

```
public interface Pizza {
    String getDescription();
    Double getCost();
}

public class BasePizza implements Pizza {

    @Override
    public String getDescription() {
        return "Thin Dough";
    }

    @Override
    public Double getCost() {
        return 3.50;
    }
}
```

Next we want to create some extras for our pizza (<b> our decorators </b>). To do that I'll use abstract decorator 

```
public class PizzaDecorator implements Pizza {

    protected Pizza tempPizza;

    public PizzaDecorator(Pizza tempPizza) {
        this.tempPizza = tempPizza;
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription();
    }

    @Override
    public Double getCost() {
        return tempPizza.getCost();
    }
}

```

In our abstract decorator class most important are: 
- implementing interface (in this case pizza interface) and override methods
- reference object with type of our interface

Now we are ready to create our decorators

```
public class Cheese extends PizzaDecorator {

    public Cheese(Pizza tempPizza) {
        super(tempPizza);
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription() + " , Cheese";
    }

    @Override
    public Double getCost() {
        return tempPizza.getCost() + 1.50;
    }
}

public class Pepperoni extends PizzaDecorator {

    public Pepperoni(Pizza tempPizza) {
        super(tempPizza);
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription() + " , Pepperoni";
    }

    @Override
    public Double getCost() {
        return tempPizza.getCost() + 1.25;
    }
}
```
And now it's time to use it and show you how easy it is!
```
Pizza tripleCheese = new Cheese(new Cheese(new Cheese(new BasePizza())));
System.out.println("Ingredients: " + tripleCheese.getDescription()); // Ingredients: Thin Dough , Cheese , Cheese , Cheese
System.out.println("Price: " + tripleCheese.getCost());              // Price: 8.0

Pizza pepperoniWithCheese = new Pepperoni(new Cheese(new BasePizza()));
System.out.println("Ingredients: " + pepperoniWithCheese.getDescription()); // Ingredients: Thin Dough , Cheese , Pepperoni
System.out.println("Price: " + pepperoniWithCheese.getCost());              // Price: 6.25
```
That's all. You can use a combination of any pizzas you want. All you need is to just create another decorators classes.

## Private notes
I should also mention about order of execution and why it's working like it do. Of course it's working because of concept of overriding e.g.
```
Pizza superMixPizza = new Cheese(new Cheese(new Pepperoni(new BasePizza())));

System.out.println("Price: " + superMixPizza.getDescription()); 
//output: 'Ingredients: Thin Dough , Pepperoni , Cheese , Cheese'
```
Look at the order of ingredients. It goes from right to left, and <b>next decorators overwrite the previous ones</b>(example below)
```
    @Override
    public String getDescription() {
        return tempPizza.getDescription() + " , Pepperoni";
    }
```


## Credits

* [Decorator Design Pattern by Derek Banas](https://www.youtube.com/watch?v=j40kRwSm4VE&t=700s)
* [Java Design Patterns by iluwatar](https://github.com/iluwatar/java-design-patterns/tree/master/decorator)