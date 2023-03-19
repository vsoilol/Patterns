package com.example.view.command;

public class ExitCommand extends Command {
    public ExitCommand(String description) {
        super(description);
    }

    @Override
    public void execute() {
        System.out.println("Exiting menu...");
    }
}
