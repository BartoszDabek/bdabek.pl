package com.bdabek.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        Pizzeria italian = new ItalianPizzeriaFactory();
        Pizzeria polish = new PolishPizzeriaFactory();

        Pizza cheeseItalianPizza = italian.make(PizzaType.CHEESE);
        Pizza cheesePolishPizza = polish.make(PizzaType.CHEESE);

        LOGGER.info("{}", cheeseItalianPizza);
        LOGGER.info("{}", cheesePolishPizza);
    }

}
