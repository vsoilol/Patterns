package com.example.dao.memory;

import com.example.beans.Product;
import com.example.beans.User;
import com.example.dao.IUserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserInMemoryRepository implements IUserRepository {
    private final List<User> users = new ArrayList<>();

    @Override
    public User findByUsername(String username) {
        return users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(User user) {
        users.add(user);
    }
}
