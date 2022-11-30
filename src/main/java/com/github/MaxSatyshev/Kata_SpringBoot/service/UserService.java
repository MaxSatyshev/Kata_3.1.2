package com.github.MaxSatyshev.Kata_SpringBoot.service;



import com.github.MaxSatyshev.Kata_SpringBoot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser (int id);
    void save(User user);
    public void update(int id, User user);
    void delete(int id);
}
