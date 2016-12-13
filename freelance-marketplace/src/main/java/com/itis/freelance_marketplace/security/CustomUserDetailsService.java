package com.itis.freelance_marketplace.security;

import com.itis.freelance_marketplace.entity.User;
import com.itis.freelance_marketplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by alt on 10.11.16.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {

        User user = userRepository.findByLogin(login);
        if (user == null) throw new UsernameNotFoundException("User with name " + login + " not found");
        return new CustomUserDetails(user);
    }
}