package com.example.service;

import com.example.beans.User;

import java.util.List;

public interface IUserService {
    boolean register(String username, String password);

    boolean login(String username, String password);

    User findByUsername(String username);
}
