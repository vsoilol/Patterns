package com.example.view;

import com.example.view.command.Command;
import com.example.view.command.LoginCommand;
import com.example.view.command.RegisterCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleMenu {
    private final Map<Integer, Command> commands;
    private final Scanner scanner = new Scanner(System.in);
    private boolean isRunning = true;
    private final String name;

    public ConsoleMenu(Map<Integer, Command> commands, String name) {
        this.commands = commands;
        this.name = name;
    }

    public void run() {
        while (isRunning) {
            System.out.println("-----------------------");
            System.out.println("Welcome to the " + name + " Menu");
            System.out.println("-----------------------");
            commands.forEach((key, value) -> System.out.println(key + ". " + value.getDescription()));
            System.out.println("-----------------------");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            Command command = commands.get(choice);
            if (command == null) {
                System.out.println("Invalid choice, please try again");
                continue;
            }

            System.out.println("-----------------------");
            command.execute();

            if (choice == commands.size()) {
                isRunning = false;
            }
        }
    }
}
