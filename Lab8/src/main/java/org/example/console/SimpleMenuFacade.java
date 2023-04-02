package org.example.console;

import org.example.fileSystem.FileSystemDirector;
import org.example.fileSystem.FileSystemTree;
import org.example.validators.FilePresenterValidator;
import org.example.validators.FileSystemBuilderValidator;

public class SimpleMenuFacade {
    public SimpleMenu createSimpleMenu() {
        FilePresenterValidator filePresenterValidator = new FilePresenterValidator();
        FileSystemBuilderValidator fileSystemBuilderValidator = new FileSystemBuilderValidator();

        ConsoleProvider consoleProvider = new ConsoleProvider();

        FileSystemDirector builder = new FileSystemDirector(fileSystemBuilderValidator, "root");
        FileSystemTree fileSystemTree = new FileSystemTree();
        FilePresenter filePresenter = new FilePresenter(builder, fileSystemTree, filePresenterValidator, consoleProvider);

        SimpleMenu simpleMenu = new SimpleMenu(filePresenter, consoleProvider);
        return simpleMenu;
    }
}
