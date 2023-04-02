package org.example;

import org.example.enumns.CrustType;
import org.example.enumns.Size;
import org.example.enumns.Topping;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input to build a Pizza using the PizzaBuilder
        PizzaBuilder builder = new PizzaBuilder();
        System.out.println("Welcome to Pizza Builder!");
        System.out.println("Let's build a pizza.");
        System.out.println("Please select the size of the pizza:");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> builder.withSize(Size.SMALL);
            case 2 -> builder.withSize(Size.MEDIUM);
            case 3 -> builder.withSize(Size.LARGE);
            default -> {
                System.out.println("Invalid choice, please try again.");
                return;
            }
        }

        System.out.println("Please select the crust type:");
        System.out.println("1) Thin crust");
        System.out.println("2) Thick crust");
        System.out.println("3) Stuffed crust");

        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> builder.withCrustType(CrustType.THIN);
            case 2 -> builder.withCrustType(CrustType.THICK);
            case 3 -> builder.withCrustType(CrustType.STUFFED);
            default -> {
                System.out.println("Invalid choice, please try again.");
                return;
            }
        }

        System.out.println("Please select your desired toppings (enter comma-separated values):");
        System.out.println("1) Pepperoni");
        System.out.println("2) Mushrooms");
        System.out.println("3) Onions");
        System.out.println("4) Sausage");
        System.out.println("5) Bacon");
        System.out.println("6) Extra cheese");

        String[] toppings = scanner.nextLine().split(",");
        for (String topping : toppings) {
            switch (topping.trim()) {
                case "1" -> builder.withTopping(Topping.PEPPERONI);
                case "2" -> builder.withTopping(Topping.MUSHROOMS);
                case "3" -> builder.withTopping(Topping.ONIONS);
                case "4" -> builder.withTopping(Topping.SAUSAGE);
                case "5" -> builder.withTopping(Topping.BACON);
                case "6" -> builder.withTopping(Topping.EXTRA_CHEESE);
                default -> System.out.println("Invalid topping: " + topping.trim());
            }
        }

        // Build the pizza using the PizzaBuilder
        Pizza pizza = builder.build();
        System.out.println("You have built the following pizza:");
        System.out.println(pizza);
    }
}