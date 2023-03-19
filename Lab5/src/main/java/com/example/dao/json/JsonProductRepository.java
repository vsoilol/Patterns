package com.example.dao.json;

import com.example.beans.Product;
import com.example.dao.IProductRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JsonProductRepository extends AbstractJsonRepository<Product> implements IProductRepository {
    public JsonProductRepository() {
        super("products.json");
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(items);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return items.stream()
                .filter(product -> product.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findProductsByNameAndMaxPrice(String name, double priceLimit) {
        return items.stream()
                .filter(product -> product.getName().equals(name) && product.getPrice() <= priceLimit)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsWithStorageTimeAfter(Date storageTime) {
        return items.stream()
                .filter(product -> product.getStorageTime().after(storageTime))
                .collect(Collectors.toList());
    }

    @Override
    public void addRange(List<Product> products) {
        items.addAll(products);
        saveDataToFile();
    }
}
