package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileAccess fileAccess = new FileAccessProxy(new RealFileAccess());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please select what you want to do:");
            System.out.println("1) Write to file");
            System.out.println("2) Read file");
            System.out.println("3) Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> writeFile(scanner, fileAccess);
                case 2 -> readFile(scanner, fileAccess);
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void readFile(Scanner scanner, FileAccess fileAccess) {
        System.out.println("Please enter file name:");

        String filePath = scanner.nextLine();

        try {
            String text = fileAccess.readFile(filePath);
            System.out.println("File data: " + text);
        } catch (IOException | SecurityException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static void writeFile(Scanner scanner, FileAccess fileAccess) {
        System.out.println("Please enter file name:");

        String filePath = scanner.nextLine();

        System.out.println("Please enter content:");

        String content = scanner.nextLine();

        try {
            fileAccess.writeFile(filePath, content);
            System.out.println("Text successfully added");
        } catch (IOException | SecurityException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
