package org.example.console;

import org.example.resources.MenuItems;
import org.example.resources.UIResources;

public class SimpleMenu {
    private final FilePresenter filePresenter;
    private final ConsoleProvider consoleProvider;

    private boolean isMenuRun = true;

    public SimpleMenu(FilePresenter filePresenter, ConsoleProvider consoleProvider) {
        this.filePresenter = filePresenter;
        this.consoleProvider = consoleProvider;
    }

    public void runMenu() {
        while (isMenuRun) {
            consoleProvider.println();
            consoleProvider.println(UIResources.FILE_MENU_NAME);
            chooseMenuItem();
        }
    }

    private void chooseMenuItem() {
        String operation = consoleProvider.prompt(UIResources.MENU_SELECTION_MESSAGE, String.class).toLowerCase();

        switch (operation) {
            case MenuItems.PRINT -> filePresenter.displayDirectoryTree();
            case MenuItems.QUIT -> {
                consoleProvider.print(UIResources.QUIT_MESSAGE);
                isMenuRun = false;
            }
            default -> filePresenter.addNewChild(operation);
        }
    }


}
