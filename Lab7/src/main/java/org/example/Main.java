package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NewsPublisher publisher = new NewsPublisher();

        NewsSubscriber subscriber1 = new NewsSubscriber("John");
        NewsSubscriber subscriber2 = new NewsSubscriber("Jane");

        publisher.attach(subscriber1);
        publisher.attach(subscriber2);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter news to publish or 'q' to quit:");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                break;
            }

            publisher.publish(input);
        }

        publisher.detach(subscriber1);
        publisher.detach(subscriber2);

        scanner.close();
    }
}