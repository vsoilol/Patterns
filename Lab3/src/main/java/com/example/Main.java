package com.example;

import com.example.controller.IUserController;
import com.example.controller.UserController;
import com.example.dao.IUserRepository;
import com.example.dao.UserRepository;
import com.example.service.IUserService;
import com.example.service.UserService;
import com.example.view.AuthorizedViewBase;
import com.example.view.MainView;
import com.example.view.ProductView;
import com.example.view.ViewBase;

public class Main {
    public static void main(String[] args){
        IUserRepository userRepository = new UserRepository();
        IUserService userService = new UserService(userRepository);
        IUserController userController = new UserController(userService);

        AuthorizedViewBase productView = new ProductView();

        ViewBase mainView = new MainView(userController, productView);
        mainView.run();
    }
}
