package org.example;
public class FoodFactory {
    public static Food getFood(String className, String[] parameters) throws ClassNotFoundException {
        return switch (className) {
            case "Apple" -> new Apple(parameters[0]);
            case "Cheese" -> new Cheese();
            case "Eggs" -> new Eggs(parameters[0]);
            case "Dessert" -> new Dessert(parameters[0], parameters[1]);
            default -> throw new ClassNotFoundException("Cannot find food " + className);
        };
    }
}
