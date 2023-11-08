package com.example.hqlandcriteriagreenatom.dao;

import com.example.hqlandcriteriagreenatom.entity.User;

import java.util.List;

public interface UserDAO {
    User findById(Long id);
    List<User> findAll();
    void save(User user);
    void update(User user);
    void delete(User user);
}