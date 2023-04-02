package org.example.validators;

public interface Validator<T> {
    void check(T toCheck);
}