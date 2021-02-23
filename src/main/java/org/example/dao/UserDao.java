package org.example.dao;


import org.example.model.User;

import java.util.List;


public interface UserDao{
    User findByLogin(String login);
    User findById(int id);
    void save(User user);
    List<User> allUser();
    void delete(User user);
    void edit(User user);
    void add(User user);
}
