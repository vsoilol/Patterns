package org.example;

interface Subject {
    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObservers(String message);
}
