package com.example.singletons;

import com.example.controller.IUserController;
import com.example.controller.UserController;

public class UserControllerSingleton {
    private static final IUserController userController = new UserController(UserServiceSingleton.getInstance());

    private UserControllerSingleton() {
    }

    public static IUserController getInstance() {
        return userController;
    }
}
