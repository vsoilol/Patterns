package org.example.fileInfo;

public class File extends FileComponent {
    private final String extension;

    public File(String name, String extension) {
        super(name);
        this.extension = extension;
    }

    @Override
    public String getName() {
        return name + "." + extension;
    }
}
