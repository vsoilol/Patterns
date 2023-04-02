package org.example.fileSystem;

import org.example.fileInfo.File;
import org.example.fileInfo.FileComponent;
import org.example.fileInfo.Folder;
import org.example.resources.ErrorMessages;
import org.example.validationModels.FilesNameValidationInfo;
import org.example.validators.Validator;

public class FileSystemDirector {
    private final Validator<FilesNameValidationInfo> validator;

    private final Folder root;
    private Folder currentDirectory;

    public FileSystemDirector(Validator<FilesNameValidationInfo> validator, String rootFolder) {
        this.validator = validator;
        this.root = new Folder(rootFolder);
        this.currentDirectory = root;
    }

    public Folder getRootFolder() {
        return root;
    }

    public void addFileTreeByFilesName(String[] filesName) {
        validator.check(new FilesNameValidationInfo(filesName, root.getName()));
        currentDirectory = root;

        for (int i = 1; i < filesName.length; i++) {
            String fileName = filesName[i];

            FileComponent childFileComponent = currentDirectory.getFileComponentByName(fileName);

            if (childFileComponent == null) {
                addNewFileComponent(fileName);
                continue;
            }

            if (childFileComponent instanceof Folder && i != filesName.length - 1) {
                currentDirectory = (Folder) childFileComponent;
                continue;
            }

            String errorMessage = ErrorMessages.ALREADY_EXIST.formatted(childFileComponent.getName());
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void addNewFileComponent(String fileName) {
        if (fileName.contains(".")) {
            var nameWithExtension = fileName.split("\\.");
            addFile(nameWithExtension[0], nameWithExtension[1]);
        } else {
            addFolder(fileName);
        }
    }

    private void addFile(String name, String extension) {
        File file = new File(name, extension);
        currentDirectory.addFileComponent(file);
    }

    private void addFolder(String name) {
        Folder folder = new Folder(name);
        this.currentDirectory.addFileComponent(folder);
        this.currentDirectory = folder;
    }
}
