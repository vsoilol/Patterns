package com.example.controller;

import com.example.beans.User;

import java.util.List;

public interface IUserController {
    boolean register(String username, String password);

    boolean login(String username, String password);

    User findByUsername(String username);
}
