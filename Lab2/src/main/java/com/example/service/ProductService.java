package com.example.service;

import com.example.beans.Product;
import com.example.dao.IProductRepository;
import com.example.dao.ProductRepository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProductService implements IProductService {
    private final IProductRepository productRepository;

    public ProductService() {
        productRepository = new ProductRepository();
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.getProductsByName(name);
    }

    @Override
    public List<Product> findProductsByNameAndMaxPrice(String name, double priceLimit) {
        return productRepository.findProductsByNameAndMaxPrice(name, priceLimit);
    }

    @Override
    public List<Product> getProductsWithStorageTimeAfter(Date storageTime)  {
        return productRepository.getProductsWithStorageTimeAfter(storageTime);
    }
}
