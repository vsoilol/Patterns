package com.example.singletons;

import com.example.dao.IUserRepository;
import com.example.dao.UserRepository;

public class UserRepositorySingleton {
    private static final IUserRepository userRepository = new UserRepository();

    private UserRepositorySingleton(){}

    public static IUserRepository getInstance(){
        return userRepository;
    }
}
