package com.bdabek.factory;

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
