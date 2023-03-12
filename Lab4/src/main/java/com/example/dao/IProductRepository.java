package com.example.dao;

import com.example.beans.Product;

import java.util.Date;
import java.util.List;

public interface IProductRepository {
    List<Product> getAll();

    List<Product> getProductsByName(String name);

    List<Product> findProductsByNameAndMaxPrice(String name, double priceLimit);

    List<Product> getProductsWithStorageTimeAfter(Date storageTime);
}
