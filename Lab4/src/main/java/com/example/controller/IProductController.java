package com.example.controller;

import com.example.beans.Product;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface IProductController {
    List<Product> getAll();

    List<Product> getProductsByName(String name);

    List<Product> findProductsByNameAndMaxPrice(String name, double priceLimit);

    List<Product> getProductsWithStorageTimeAfter(String storageTime) throws ParseException;
}
