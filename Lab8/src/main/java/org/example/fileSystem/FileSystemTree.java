package org.example.fileSystem;

import org.example.fileInfo.File;
import org.example.fileInfo.FileComponent;
import org.example.fileInfo.Folder;
import org.example.resources.ErrorMessages;

public class FileSystemTree {
    public String printDirectoryTree(FileComponent folder) {
        if (folder instanceof File) {
            String errorMessage = ErrorMessages.FILE_COMPONENT_IS_NOT_FOLDER.formatted(folder.getName());
            throw new IllegalArgumentException(errorMessage);
        }

        int indent = 0;

        StringBuilder sb = new StringBuilder();
        printDirectoryTree(folder, indent, sb);

        return sb.toString();
    }

    private void printDirectoryTree(FileComponent folder, int indent, StringBuilder sb) {
        if (folder instanceof File) {
            String errorMessage = ErrorMessages.FILE_COMPONENT_IS_NOT_FOLDER.formatted(folder.getName());
            throw new IllegalArgumentException(errorMessage);
        }

        sb.append(getIndentString(indent));
        sb.append("+--");
        sb.append(folder.getName());
        sb.append("/");
        sb.append("\n");

        for (FileComponent file : ((Folder) folder).getSubFileComponents()) {
            if (file instanceof Folder) {
                printDirectoryTree(file, indent + 1, sb);
            } else {
                printFile(file, indent + 1, sb);
            }
        }

    }

    private void printFile(FileComponent file, int indent, StringBuilder sb) {
        sb.append(getIndentString(indent));
        sb.append("+--");
        sb.append(file.getName());
        sb.append("\n");
    }

    private String getIndentString(int indent) {
        return "|  ".repeat(indent);
    }
}
