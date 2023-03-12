package com.example.dao;

import com.example.beans.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    public final List<User> users = new ArrayList<>() {{
        add(new User("user1", "12345"));
    }};

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
