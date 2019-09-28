package com.bdabek.factory;

class PolishPizzeriaFactory implements Pizzeria {

    @Override
    public Pizza make(PizzaType pizzaType) {
        Pizza pizza;
        switch (pizzaType) {
            case CHEESE:
                pizza = new PolishCheesePizza();
                break;
            case VEGETARIAN:
                pizza = new PolishVegetarianPizza();
                break;
            case FARM:
                pizza = new PolishFarmPizza();
                break;
            default:
                throw new IllegalStateException("No such value in our menu " + pizzaType);
        }

        return pizza;
    }
}
