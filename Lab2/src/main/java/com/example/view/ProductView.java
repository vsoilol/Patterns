package com.example.view;

import com.example.beans.Product;
import com.example.controller.IProductController;
import com.example.controller.ProductController;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class ProductView implements ViewBase{
    private final IProductController productController;

    public ProductView() {
        this.productController = new ProductController();
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Get all products");
            System.out.println("2. Get products by name");
            System.out.println("3. Get products by name and price less then entered");
            System.out.println("4. Get products whose storage time is longer than the entered");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listProducts();
                    break;
                case 2:
                    getProductsByName(scanner);
                    break;
                case 3:
                    findProductsByNameAndMaxPrice(scanner);
                    break;
                case 4:
                    getProductsWithStorageTimeAfter(scanner);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
        }
    }

    private void listProducts() {
        System.out.println("Product List:");
        productController.getAll().forEach(System.out::println);
    }

    private void getProductsByName(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.next();

        System.out.println("Product List:");
        productController.getProductsByName(name).forEach(System.out::println);
    }

    private void findProductsByNameAndMaxPrice(Scanner scanner) {
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

    private void getProductsWithStorageTimeAfter(Scanner scanner) {
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
