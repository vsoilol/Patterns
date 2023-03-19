package com.example;

import com.example.controller.IProductController;
import com.example.controller.IUserController;
import com.example.dao.factory.InMemoryRepositoryFactory;
import com.example.dao.factory.JsonRepositoryFactory;
import com.example.dao.factory.RepositoryFactory;
import com.example.factories.ProductControllerFactory;
import com.example.factories.UserControllerFactory;
import com.example.view.ConsoleMenu;
import com.example.view.command.*;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RepositoryFactory repositoryFactory = promptForRepositoryFactory(scanner);

        IProductController productController = ProductControllerFactory.createProductController(repositoryFactory);
        IUserController userController = UserControllerFactory.createUserController(repositoryFactory);

        Map<Integer, Command> productMenuCommands = getProductMenuCommands(productController, scanner);
        ConsoleMenu productMenu = new ConsoleMenu(productMenuCommands, "Product");

        Map<Integer, Command> mainMenuCommands = getMainMenuCommands(userController, scanner, productMenu);
        ConsoleMenu mainMenu = new ConsoleMenu(mainMenuCommands, "Main");

        mainMenu.run();
    }

    private static Map<Integer, Command> getMainMenuCommands(IUserController userController, Scanner scanner,
                                                             ConsoleMenu productMenu) {
        Command exitCommand = new ExitCommand("Exit");
        Command loginCommand = new LoginCommand(userController, scanner, productMenu, "Login");
        Command registerCommand = new RegisterCommand(userController, scanner, productMenu, "Register");

        Map<Integer, Command> mainMenuCommands = new TreeMap<>();

        mainMenuCommands.put(1, loginCommand);
        mainMenuCommands.put(2, registerCommand);
        mainMenuCommands.put(3, exitCommand);

        return mainMenuCommands;
    }

    private static Map<Integer, Command> getProductMenuCommands(IProductController controller, Scanner scanner) {
        Command logoutCommand = new ExitCommand("Log out");
        Command listProductsCommand = new ListProductsCommand("Get all products", controller);
        Command getProductsByNameCommand = new GetProductsByNameCommand("Get products by name", controller, scanner);
        Command findProductsByNameAndMaxPriceCommand = new FindProductsByNameAndMaxPriceCommand(
                "Get products by name and price less then entered", controller, scanner);
        Command getProductsWithStorageTimeAfterCommand = new GetProductsWithStorageTimeAfterCommand(
                "Get products whose storage time is longer than the entered", controller, scanner);

        Map<Integer, Command> productMenuCommands = new TreeMap<>();

        productMenuCommands.put(1, listProductsCommand);
        productMenuCommands.put(2, getProductsByNameCommand);
        productMenuCommands.put(3, findProductsByNameAndMaxPriceCommand);
        productMenuCommands.put(4, getProductsWithStorageTimeAfterCommand);
        productMenuCommands.put(5, logoutCommand);

        return productMenuCommands;
    }

    private static RepositoryFactory promptForRepositoryFactory(Scanner scanner) {
        RepositoryFactory repositoryFactory = null;
        boolean isValidChoice = false;

        while (!isValidChoice) {
            System.out.println("Select the type of data storage:");
            System.out.println("1) Json");
            System.out.println("2) In memory");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    repositoryFactory = new JsonRepositoryFactory();
                    isValidChoice = true;
                }
                case 2 -> {
                    repositoryFactory = new InMemoryRepositoryFactory();
                    isValidChoice = true;
                }
                default -> System.out.println("Invalid choice, please try again");
            }
        }

        return repositoryFactory;
    }
}
