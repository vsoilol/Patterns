package com.example.dao.json;

import com.example.beans.Product;
import com.example.beans.User;
import com.example.dao.IUserRepository;

import java.util.List;

public class JsonUserRepository extends AbstractJsonRepository<User> implements IUserRepository {
    public JsonUserRepository() {
        super("users.json");
    }

    @Override
    public User findByUsername(String username) {
        return items.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(User user) {
        items.add(user);
        saveDataToFile();
    }
}
