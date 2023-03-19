package com.example.service;

import com.example.beans.Product;
import com.example.dao.IProductRepository;
import com.example.dao.IUserRepository;
import com.example.dao.memory.ProductInMemoryRepository;

import java.util.Date;
import java.util.List;

public class ProductService implements IProductService {
    private final IProductRepository productRepository;

    public ProductService() {
        this(new ProductInMemoryRepository());
    }

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
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
    public List<Product> getProductsWithStorageTimeAfter(Date storageTime) {
        return productRepository.getProductsWithStorageTimeAfter(storageTime);
    }
}
