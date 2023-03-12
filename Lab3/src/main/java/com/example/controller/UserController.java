package com.example.controller;

import com.example.beans.User;
import com.example.service.IUserService;

public class UserController implements IUserController{
    private final IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
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
}
