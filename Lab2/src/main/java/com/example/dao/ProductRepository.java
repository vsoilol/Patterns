package com.example.dao;

import com.example.beans.Product;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepository implements IProductRepository{
    @Override
    public List<Product> getAll() {
        return ProductStorage.PRODUCTS;
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return ProductStorage.PRODUCTS.stream()
                .filter(product -> product.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findProductsByNameAndMaxPrice(String name, double priceLimit) {
        return ProductStorage.PRODUCTS.stream()
                .filter(product -> product.getName().equals(name) && product.getPrice() <= priceLimit)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsWithStorageTimeAfter(Date storageTime) {
        return ProductStorage.PRODUCTS.stream()
                .filter(product -> product.getStorageTime().after(storageTime))
                .collect(Collectors.toList());
    }
}
