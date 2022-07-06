package com.example.cqrs.Repository;

import java.util.HashMap;
import java.util.Map;

import com.example.cqrs.Domain.User;

import org.springframework.stereotype.Component;

@Component
public class UserWriteRepository {
    private Map<String, User> store = new HashMap<>();

    public void addUser(String id, User user) {
        store.put(id, user);
    }

    public User getUser(String id) {
        return store.get(id);
    }
}
