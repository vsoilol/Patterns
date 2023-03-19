package com.example.dao.factory;

import com.example.beans.DateUtils;
import com.example.beans.Product;
import com.example.beans.User;
import com.example.dao.IProductRepository;
import com.example.dao.IUserRepository;
import com.example.dao.json.JsonProductRepository;
import com.example.dao.json.JsonUserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JsonRepositoryFactory implements RepositoryFactory {
    public final List<Product> products = new ArrayList<Product>() {
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

    public final List<User> users = new ArrayList<>() {{
        add(new User("user1", "12345"));
    }};

    public IUserRepository createUserRepository() {
        return new JsonUserRepository();
    }

    public IProductRepository createProductRepository() {
        return new JsonProductRepository();
    }
}
