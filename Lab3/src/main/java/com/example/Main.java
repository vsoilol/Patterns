package com.example;

import com.example.controller.IUserController;
import com.example.controller.UserController;
import com.example.view.AuthorizedViewBase;
import com.example.view.MainView;
import com.example.view.ProductView;
import com.example.view.ViewBase;

public class Main {
    public static void main(String[] args){
        IUserController userController = UserController.getInstance();

        AuthorizedViewBase productView = new ProductView();

        ViewBase mainView = new MainView(userController, productView);
        mainView.run();
    }
}
