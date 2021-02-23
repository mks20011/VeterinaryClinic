package org.example.service;


import org.example.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    User findById(int id);
    User findByLogin(String login);
    String getUserLogin();
    List<User> allUser();
    void add(User user);
    void delete(User user);
    void edit(User user);
}