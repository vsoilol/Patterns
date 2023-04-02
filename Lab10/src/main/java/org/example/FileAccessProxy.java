package org.example;

import java.io.IOException;

public class FileAccessProxy implements FileAccess{
    private final FileAccess realFileAccess;

    public FileAccessProxy(FileAccess realFileAccess) {
        this.realFileAccess = realFileAccess;
    }

    @Override
    public String readFile(String fileName) throws IOException, SecurityException {
        if (isRestricted(fileName)) {
            throw new SecurityException("Access to file " + fileName + " is not allowed.");
        }

        return realFileAccess.readFile(fileName);
    }

    @Override
    public void writeFile(String fileName, String content) throws IOException, SecurityException {
        if (isRestricted(fileName)) {
            throw new SecurityException("Access to file " + fileName + " is not allowed.");
        }

        realFileAccess.writeFile(fileName, content);
    }

    private boolean isRestricted(String fileName) {
        return fileName.endsWith(".secret");
    }
}
