package com.example.dao;

import com.example.beans.User;

import java.util.List;

public interface IUserRepository {
    User findByUsername(String username);

    void save(User user);
}
