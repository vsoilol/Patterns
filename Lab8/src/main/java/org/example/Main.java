package org.example;

import org.example.console.SimpleMenu;
import org.example.console.SimpleMenuFacade;

public class Main {
    public static void main(String[] args) {
        SimpleMenuFacade simpleMenuFacade = new SimpleMenuFacade();
        SimpleMenu menu = simpleMenuFacade.createSimpleMenu();
        menu.runMenu();
    }
}