package com.itis.freelance_marketplace.repository;

import com.itis.freelance_marketplace.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alt on 10.11.16.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();

    User findByLogin(String login);

    User findByEmail(String email);
}

