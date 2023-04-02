package org.example;

import java.util.Scanner;

class CoffeeShop {
    private CoffeeMachine coffeeMachine;
    private CashRegister cashRegister;
    private Scanner scanner;

    public CoffeeShop() {
        coffeeMachine = new CoffeeMachine();
        cashRegister = new CashRegister();
        scanner = new Scanner(System.in);
    }

    public void takeOrder() {
        System.out.println("What would you like to order?");
        String order = scanner.nextLine();

        switch (order) {
            case "coffee" -> {
                coffeeMachine.makeCoffee();
                cashRegister.takePayment(1.50);
            }
            case "latte" -> {
                coffeeMachine.makeLatte();
                cashRegister.takePayment(2.50);
            }
            default -> System.out.println("Sorry, we don't have that.");
        }
    }
}
