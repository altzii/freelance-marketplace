package com.itis.freelance_marketplace.service;

import com.itis.freelance_marketplace.entity.User;

import java.util.List;

/**
 * Created by alt on 10.11.16.
 */
public interface UserService {
    User create(User user);

    User delete(long id);

    List<User> findAll();

    User update(User user);

    User findById(long id);

    User findByLogin(String login);

    User findByEmail(String email);
}

