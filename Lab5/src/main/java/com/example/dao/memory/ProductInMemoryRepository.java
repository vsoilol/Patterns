package com.example.dao.memory;

import com.example.beans.Product;
import com.example.dao.IProductRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ProductInMemoryRepository implements IProductRepository {
    private final List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return products.stream()
                .filter(product -> product.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findProductsByNameAndMaxPrice(String name, double priceLimit) {
        return products.stream()
                .filter(product -> product.getName().equals(name) && product.getPrice() <= priceLimit)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsWithStorageTimeAfter(Date storageTime) {
        return products.stream()
                .filter(product -> product.getStorageTime().after(storageTime))
                .collect(Collectors.toList());
    }

    @Override
    public void addRange(List<Product> products) {
        this.products.addAll(products);
    }
}
