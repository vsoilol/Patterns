package com.example.dao.factory;

import com.example.dao.IProductRepository;
import com.example.dao.IUserRepository;

public interface RepositoryFactory {
    IUserRepository createUserRepository();
    IProductRepository createProductRepository();
}
