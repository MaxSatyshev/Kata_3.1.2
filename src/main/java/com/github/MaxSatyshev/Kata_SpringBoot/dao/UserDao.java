package com.github.MaxSatyshev.Kata_SpringBoot.dao;



import com.github.MaxSatyshev.Kata_SpringBoot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User getUser (int id);
    void save(User user);
    void update(int id, User user);
    void delete(int id);
}
