package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class RealFileAccess implements FileAccess {
    @Override
    public String readFile(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        if (!Files.exists(filePath)) {
            throw new FileNotFoundException("File not found: " + fileName);
        }

        String fileContent = Files.readString(filePath);
        return fileContent;
    }

    @Override
    public void writeFile(String fileName, String content) throws IOException {
        Path filePath = Paths.get(fileName);
        Files.writeString(filePath, content, StandardOpenOption.CREATE);
    }
}
