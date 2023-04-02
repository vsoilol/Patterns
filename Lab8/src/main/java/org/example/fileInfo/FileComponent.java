package org.example.fileInfo;

public abstract class FileComponent {
    protected String name;

    public FileComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
