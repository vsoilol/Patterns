package com.example.dao.factory;

import com.example.dao.IProductRepository;
import com.example.dao.IUserRepository;
import com.example.dao.memory.ProductInMemoryRepository;
import com.example.dao.memory.UserInMemoryRepository;

public class InMemoryRepositoryFactory implements RepositoryFactory{
    public IUserRepository createUserRepository() {
        return new UserInMemoryRepository();
    }

    public IProductRepository createProductRepository() {
        return new ProductInMemoryRepository();
    }
}
