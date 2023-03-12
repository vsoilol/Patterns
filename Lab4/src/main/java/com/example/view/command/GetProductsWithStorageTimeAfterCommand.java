package com.example.view.command;

import com.example.beans.Product;
import com.example.controller.IProductController;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class GetProductsWithStorageTimeAfterCommand extends Command{
    private final IProductController productController;

    private final Scanner scanner;

    public GetProductsWithStorageTimeAfterCommand(String description, IProductController productController, Scanner scanner) {
        super(description);
        this.productController = productController;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter a storage time (dd.mm.yyyy): ");
        String storageTime = scanner.next();

        List<Product> products;

        try {
            products = productController.getProductsWithStorageTimeAfter(storageTime);
        } catch (ParseException e) {
            System.out.println("Invalid input, please enter a valid date value.");
            return;
        }

        System.out.println("Product List:");
        products.forEach(System.out::println);
    }
}
