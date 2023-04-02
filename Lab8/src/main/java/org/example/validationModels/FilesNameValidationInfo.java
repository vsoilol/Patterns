package org.example.validationModels;

public class FilesNameValidationInfo {
    private final String[] filesName;
    private final String rootFolderName;

    public FilesNameValidationInfo(String[] filesName, String rootFolderName) {
        this.filesName = filesName;
        this.rootFolderName = rootFolderName;
    }

    public String getRootFolderName() {
        return rootFolderName;
    }

    public String[] getFilesName() {
        return filesName;
    }
}
