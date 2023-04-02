package org.example;

import java.util.ArrayList;
import java.util.List;

class NewsPublisher implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void publish(String news) {
        System.out.println("Publishing news: " + news);
        notifyObservers(news);
    }
}
