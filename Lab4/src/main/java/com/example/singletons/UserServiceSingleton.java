package com.example.singletons;

import com.example.service.IUserService;
import com.example.service.UserService;

public class UserServiceSingleton {
    private static final IUserService userService = new UserService(UserRepositorySingleton.getInstance());

    private UserServiceSingleton(){}

    public static IUserService getInstance(){
        return userService;
    }
}
