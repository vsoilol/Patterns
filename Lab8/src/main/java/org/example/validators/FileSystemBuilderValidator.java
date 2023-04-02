package org.example.validators;

import org.example.resources.ErrorMessages;
import org.example.validationModels.FilesNameValidationInfo;

import java.util.Objects;

public class FileSystemBuilderValidator implements Validator<FilesNameValidationInfo> {
    @Override
    public void check(FilesNameValidationInfo toCheck) {
        String[] filesName = toCheck.getFilesName();
        String rootFolderName = toCheck.getRootFolderName();

        if (!Objects.equals(rootFolderName, filesName[0])) {
            throw new IllegalArgumentException(ErrorMessages.FOLDER_DOES_NOT_EXIST.formatted(filesName[0]));
        }

        if (filesName.length == 1) {
            String errorMessage = ErrorMessages.ALREADY_EXIST.formatted(rootFolderName);
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
