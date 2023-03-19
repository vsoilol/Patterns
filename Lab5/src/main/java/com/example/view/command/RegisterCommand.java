package com.example.view.command;

import com.example.controller.IUserController;
import com.example.view.ConsoleMenu;

import java.util.Scanner;

public class RegisterCommand extends Command {
    private final IUserController userController;
    private final Scanner scanner;
    private final ConsoleMenu consoleMenu;

    public RegisterCommand(IUserController userController, Scanner scanner, ConsoleMenu consoleMenu, String description) {
        super(description);
        this.userController = userController;
        this.scanner = scanner;
        this.consoleMenu = consoleMenu;
    }

    @Override
    public void execute() {
        System.out.print("Enter username: ");
        String username = scanner.next();

        System.out.print("Enter password: ");
        String password = scanner.next();

        boolean success = userController.register(username, password);

        if (success) {
            System.out.println("Register successfully");
            consoleMenu.run();
        } else {
            System.out.println("Username is already exist");
        }
    }
}
