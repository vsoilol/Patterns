package org.example;

import java.rmi.NoSuchObjectException;

public class FoodFactory {
    public static Food getFood(String className, String parameter) throws ClassNotFoundException {
        return switch (className) {
            case "Apple" -> new Apple(parameter);
            case "Cheese" -> new Cheese();
            case "Eggs" -> new Eggs(parameter);
            default -> throw new ClassNotFoundException("Cannot find food " + className);
        };
    }
}
