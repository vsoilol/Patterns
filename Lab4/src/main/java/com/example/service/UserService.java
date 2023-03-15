package com.example.service;

import com.example.beans.User;
import com.example.dao.IUserRepository;
import com.example.dao.UserRepository;

import java.util.List;

public class UserService implements IUserService{
    private static final IUserService userService = new UserService();

    private final IUserRepository userRepository;

    private UserService(){
        userRepository = UserRepository.getInstance();
    }

    @Override
    public boolean register(String username, String password) {
        if (userRepository.findByUsername(username) != null) {
            return false; // username already exists
        }

        User user = new User(username, password);
        userRepository.save(user);

        return true;
    }

    @Override
    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            return false; // username not found
        }

        return user.getPassword().equals(password);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public static IUserService getInstance(){
        return userService;
    }
}
