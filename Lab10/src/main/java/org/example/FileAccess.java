package org.example;

import java.io.IOException;

public interface FileAccess {
    String readFile(String fileName) throws IOException, SecurityException;
    void writeFile(String fileName, String content) throws IOException, SecurityException;
}
