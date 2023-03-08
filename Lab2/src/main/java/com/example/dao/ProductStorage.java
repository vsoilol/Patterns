package com.example.dao;

import com.example.beans.DateUtils;
import com.example.beans.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.util.*;

public final class ProductStorage {
    public static final List<Product> PRODUCTS = new ArrayList<Product>() {
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
}
