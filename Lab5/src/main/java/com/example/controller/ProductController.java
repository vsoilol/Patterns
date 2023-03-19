package com.example.controller;

import com.example.beans.Product;
import com.example.service.IProductService;
import com.example.service.ProductService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProductController implements IProductController{
    private final IProductService productService;

    public ProductController() {
        this.productService = new ProductService();
    }

    public ProductController(IProductService productService){
        this.productService = productService;
    }

    @Override
    public List<Product> getAll() {
        return productService.getAll();
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productService.getProductsByName(name);
    }

    @Override
    public List<Product> findProductsByNameAndMaxPrice(String name, double priceLimit) {
        return productService.findProductsByNameAndMaxPrice(name, priceLimit);
    }

    @Override
    public List<Product> getProductsWithStorageTimeAfter(String storageTime) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = dateFormat.parse(storageTime);

        return productService.getProductsWithStorageTimeAfter(date);
    }
}
