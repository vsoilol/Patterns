package com.example.view;

import com.example.beans.User;
import com.example.controller.IUserController;

import java.util.Scanner;

public class MainView implements ViewBase {
    private final IUserController userController;
    private final AuthorizedViewBase authorizedView;

    public MainView(IUserController userController, AuthorizedViewBase authorizedView) {
        this.userController = userController;
        this.authorizedView = authorizedView;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> loginOrRegister(scanner, false);
                case 2 -> loginOrRegister(scanner, true);
                case 3 -> System.exit(0);
                default -> System.out.println("Invalid choice, please try again");
            }
        }
    }

    private void loginOrRegister(Scanner scanner, boolean isRegistering) {
        String action = isRegistering ? "Register" : "Login";
        System.out.printf("Enter username to %s: ", action);
        String username = scanner.next();

        System.out.printf("Enter password to %s: ", action);
        String password = scanner.next();

        boolean success = isRegistering ? userController.register(username, password)
                : userController.login(username, password);

        if (success) {
            System.out.println(action + " successfully");
            User user = userController.findByUsername(username);
            authorizedView.run(user);
        } else {
            System.out.println("Invalid username or password");
        }
    }
}
