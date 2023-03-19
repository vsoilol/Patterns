package com.example.view.command;

import com.example.controller.IProductController;

import java.util.Scanner;

public class FindProductsByNameAndMaxPriceCommand extends Command{
    private final IProductController productController;

    private final Scanner scanner;

    public FindProductsByNameAndMaxPriceCommand(String description, IProductController productController, Scanner scanner) {
        super(description);
        this.productController = productController;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter product name: ");
        String name = scanner.next();

        System.out.print("Enter max price: ");
        String maxPrice = scanner.next();

        double value;

        try {
            value = Double.parseDouble(maxPrice);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, please enter a valid double value.");
            return;
        }

        System.out.println("Product List:");
        productController.findProductsByNameAndMaxPrice(name, value).forEach(System.out::println);
    }
}
