package com.example.controller;

import com.example.beans.User;
import com.example.service.IUserService;
import com.example.service.UserService;

public class UserController implements IUserController{
    private static final IUserController userController = new UserController();

    private final IUserService userService;

    private UserController(){
        this.userService = UserService.getInstance();
    }

    @Override
    public boolean register(String username, String password) {
        return userService.register(username, password);
    }

    @Override
    public boolean login(String username, String password) {
        return userService.login(username, password);
    }

    @Override
    public User findByUsername(String username) {
        return userService.findByUsername(username);
    }

    public static IUserController getInstance() {
        return userController;
    }
}
