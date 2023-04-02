package org.example;

public interface Builder<T> {
    T build() throws IllegalArgumentException;
}
