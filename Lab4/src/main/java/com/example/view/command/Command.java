package com.example.view.command;

public abstract class Command {
    protected String description;

    protected Command(String description) {
        this.description = description;
    }

    public abstract void execute();

    public String getDescription(){
        return description;
    }
}
