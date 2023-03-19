package com.example.view.command;

import com.example.controller.IProductController;

public class ListProductsCommand extends Command{
    private final IProductController productController;

    public ListProductsCommand(String description, IProductController productController) {
        super(description);
        this.productController = productController;
    }

    @Override
    public void execute() {
        System.out.println("Product List:");
        productController.getAll().forEach(System.out::println);
    }
}
