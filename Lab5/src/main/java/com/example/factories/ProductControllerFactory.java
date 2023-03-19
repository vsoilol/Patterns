package com.example.factories;

import com.example.beans.DateUtils;
import com.example.beans.Product;
import com.example.controller.IProductController;
import com.example.controller.ProductController;
import com.example.dao.IProductRepository;
import com.example.dao.factory.RepositoryFactory;
import com.example.service.IProductService;
import com.example.service.ProductService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductControllerFactory {
    private static final List<Product> products = new ArrayList<Product>() {
        {
            add(new Product("Product1",
                    "Manufacturer1",
                    11.2,
                    DateUtils.asDate(LocalDate.of(2023, 3, 8)),
                    10, "code1"));
            add(new Product("Product1",
                    "Manufacturer3",
                    21.2,
                    DateUtils.asDate(LocalDate.of(2023, 3, 20)),
                    10, "code3"));
            add(new Product("Product1",
                    "Manufacturer3",
                    5.36,
                    DateUtils.asDate(LocalDate.of(2024, 3, 20)),
                    10, "code3"));
            add(new Product("Product1",
                    "Manufacturer23",
                    40,
                    DateUtils.asDate(LocalDate.of(2024, 3, 20)),
                    10, "code32"));
            add(new Product("Product2",
                    "Manufacturer2",
                    22.2,
                    DateUtils.asDate(LocalDate.of(2023, 1, 1)),
                    10, "code2"));
            add(new Product("Product3",
                    "Manufacturer3",
                    33.2,
                    DateUtils.asDate(LocalDate.of(2023, 2, 2)),
                    10, "code3"));
        }
    };

    public static IProductController createProductController(RepositoryFactory repositoryFactory) {
        IProductRepository productRepository = repositoryFactory.createProductRepository();
        initProductsData(productRepository);
        IProductService productService = new ProductService(productRepository);
        return new ProductController(productService);
    }

    private static void initProductsData(IProductRepository productRepository) {
        if (productRepository.getAll().isEmpty()) {
            productRepository.addRange(products);
        }
    }
}
