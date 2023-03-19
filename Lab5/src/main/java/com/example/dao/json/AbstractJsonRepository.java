package com.example.dao.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractJsonRepository<T> {
    private final String fileName;
    protected final List<T> items;

    public AbstractJsonRepository(String fileName) {
        this.fileName = fileName;
        items = loadDataFromFile();
    }

    protected List<T> loadDataFromFile() {
        try {
            String data = Files.readString(Path.of(fileName));

            Gson gson = new Gson();
            Type type = TypeToken.getParameterized(List.class, getGenericTypeArgument()).getType();
            return gson.fromJson(data, type);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    protected void saveDataToFile() {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String data = gson.toJson(items);
            Files.writeString(Path.of(fileName), data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Type getGenericTypeArgument() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) type;
        Type[] typeArguments = paramType.getActualTypeArguments();
        return typeArguments[0];
    }
}
