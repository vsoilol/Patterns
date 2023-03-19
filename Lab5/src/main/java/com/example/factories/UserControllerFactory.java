package com.example.factories;

import com.example.controller.IUserController;
import com.example.controller.UserController;
import com.example.dao.IUserRepository;
import com.example.dao.factory.RepositoryFactory;
import com.example.service.IUserService;
import com.example.service.UserService;

import java.util.Scanner;

public class UserControllerFactory {
    public static IUserController createUserController(RepositoryFactory repositoryFactory) {
        IUserRepository userRepository = repositoryFactory.createUserRepository();
        IUserService userService = new UserService(userRepository);
        return new UserController(userService);
    }
}
