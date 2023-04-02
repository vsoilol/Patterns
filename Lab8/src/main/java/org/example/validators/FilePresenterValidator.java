package org.example.validators;

import org.example.resources.ErrorMessages;
import org.example.resources.RegularExpressions;

public class FilePresenterValidator implements Validator<String> {
    @Override
    public void check(String toCheck) {
        if (!toCheck.matches(RegularExpressions.FILE_PATH)) {
            throw new IllegalArgumentException(ErrorMessages.FILE_PATH_INCORRECT);
        }
    }
}
