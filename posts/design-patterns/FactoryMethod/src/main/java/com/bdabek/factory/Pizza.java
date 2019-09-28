package com.bdabek.factory;

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
}
