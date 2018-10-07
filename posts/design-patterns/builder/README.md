---
layout: pattern
title: Builder
categories: Creational
---

## Intent
Separate the construction of a complex object from its
representation so that the same construction process can create different
representations.

## Explanation

Real world example

> Imagine that you are in a restaurant. The restaurant sells sets of meals - main course, something to drink and dessert - and defines them on the menu, e.g. ( adults meal, kids meal, etc.. ).  <br>
> <center><b>Each set of meals represents a builder pattern </b></center>


**Programmatic Example**

Let's take the restaurant example. First of all we have to implement our meal class. It's a normal java bean class..

```
public class Meal {
    private String mainCourse;
    private String drink;
    private String dessert;
    
    // getters and setters
    ...
}
```

Next we defining builder interface and implements specific builders. 
Notice that our specific builders know how to build actual object, they are responsible for this.

```
public interface MealBuilder {
    void buildDrink();
    void buildMain();
    void buildDessert();
    Meal getMeal();
}

public class KidsMealBuilder implements MealBuilder {

    private Meal meal;

    public KidsMealBuilder() {
        this.meal = new Meal();
    }

    @Override
    public void buildDrink() {
        meal.setDrink("Coca-Cola");
    }

    @Override
    public void buildMain() {
        meal.setMainCourse("French fries");
    }

    @Override
    public void buildDessert() {
        meal.setDessert("Ice creams");
    }

    @Override
    public Meal getMeal() {
        return this.meal;
    }
}

// AdultsMealBuilder implementations similarly...
```

Next, we have to implement director class. Consider this class as a waitress/waiter in our restaurant. You just choose something and you don't care how excaly it's done.

```
public class MealDirector {

    private MealBuilder mealBuilder;

    public MealDirector(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public Meal getMeal() {
        this.mealBuilder.buildDessert();
        this.mealBuilder.buildDrink();
        this.mealBuilder.buildMain();

        return this.mealBuilder.getMeal();
    }
}
```

And now it can be used like this

```
MealBuilder kidBuilder = new KidsMealBuilder();
MealDirector kidDirector = new MealDirector(kidBuilder);
Meal kidsMeal = kidDirector.getMeal();

System.out.println(kidsMeal.getDessert());     	// Ice creams
System.out.println(kidsMeal.getDrink());	   	// Coca-Cola
System.out.println(kidsMeal.getMainCourse());  	// French fries

MealBuilder adultBuilder = new AdultsMealBuilder();
MealDirector adultDirector = new MealDirector(adultBuilder);
Meal adultsMeal = adultDirector.getMeal();

System.out.println(adultsMeal.getDessert());     // Cake
System.out.println(adultsMeal.getDrink());		 // Wine
System.out.println(adultsMeal.getMainCourse());  // Pan Fried Salmon with Watercress
```

## Private notes

Sometimes you don't want to implement director class, for example when you have only one builder. Consider a case that instead of these Adults/Kids Meal builders you just have a custom builder where user deciding what exactly he wants. 

Our builder will look similar but now methods responsible for creating object returning builder class instance
```
public class CustomBuilderImpl implements CustomBuilder {

    private Meal meal;

    public CustomBuilderImpl() {
        this.meal = new Meal();
    }

    @Override
    public CustomBuilder buildDrink(String text) {
        meal.setDrink(text);
        return this;
    }

    @Override
    public CustomBuilder buildMain(String text) {
        meal.setMainCourse(text);
        return this;
    }

    @Override
    public CustomBuilder buildDessert(String text) {
        meal.setDessert(text);
        return this;
    }

    @Override
    public Meal getMeal() {
        return this.meal;
    }
}
```
So we can use it this way
```
Meal customMeal = new CustomBuilderImpl()
        .buildDessert("Some dessert")
        .buildDrink("Some Drink")
        .buildMain("Some main dish")
        .getMeal();

System.out.println(customMeal.getDessert());      // Some dessert
System.out.println(customMeal.getMainCourse());   // Some Drink
System.out.println(customMeal.getDrink());		  // Some main dish
```
While we creating CustomBuilder, then in fact meal object is also created. Each of 
```
.buildDessert("Some dessert")
```
invocation updating our meal object (calls the setter method). And finally 
```
.getMeal();
```
is returning our specific meal object.
<br>
<h4>What are pros of using it this way?</h4
<br>
  We <b>avoid using the constructor</b>, we do not need to know what the sequence of parameters are, we just call .buildSomething and that's what we get.
  
## Credits

* [Builder Design Pattern by Derek Banas](https://www.youtube.com/watch?v=9XnsOpjclUg)
* [Java Design Patterns by iluwatar](https://github.com/iluwatar/java-design-patterns/tree/master/builder)