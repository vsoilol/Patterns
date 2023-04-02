package org.example.fileInfo;

import java.util.ArrayList;
import java.util.Objects;

public class Folder extends FileComponent {
    private final ArrayList<FileComponent> subFileComponents = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    public ArrayList<FileComponent> getSubFileComponents() {
        return subFileComponents;
    }

    public void addFileComponent(FileComponent component) {
        subFileComponents.add(component);
    }

    public FileComponent getFileComponentByName(String name) {
        return subFileComponents.stream()
                .filter(file -> Objects.equals(file.getName(), name))
                .findFirst()
                .orElse(null);
    }
}
