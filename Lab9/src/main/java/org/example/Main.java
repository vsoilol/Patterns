package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop();

        boolean running = true;
        while (running) {
            System.out.println("Welcome to the coffee shop! What can we get for you?");
            coffeeShop.takeOrder();

            System.out.println("Is there anything else you'd like to order? (y/n)");
            String response = new Scanner(System.in).nextLine();
            running = response.equals("y");
        }

        System.out.println("Thank you for visiting the coffee shop!");
    }
}