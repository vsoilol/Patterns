package com.example.view.command;

import com.example.controller.IProductController;

import java.util.Scanner;

public class GetProductsByNameCommand extends Command{
    private final IProductController productController;

    private final Scanner scanner;

    public GetProductsByNameCommand(String description, IProductController productController, Scanner scanner) {
        super(description);
        this.productController = productController;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter product name: ");
        String name = scanner.next();

        System.out.println("Product List:");
        productController.getProductsByName(name).forEach(System.out::println);
    }
}
