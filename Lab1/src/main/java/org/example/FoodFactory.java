package org.example;

import java.rmi.NoSuchObjectException;

public class FoodFactory {
    public static Food getFood(String className, String parameter) throws NoSuchObjectException {
        return switch (className) {
            case "Apple" -> new Apple(parameter);
            case "Cheese" -> new Cheese();
            case "Eggs" -> new Eggs(parameter);
            default -> throw new NoSuchObjectException("Cannot find food " + className);
        };
    }
}
