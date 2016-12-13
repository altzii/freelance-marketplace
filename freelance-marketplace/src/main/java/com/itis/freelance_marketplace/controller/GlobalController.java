package com.itis.freelance_marketplace.controller;

import com.itis.freelance_marketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by alt on 13.12.16.
 */
@ControllerAdvice
public class GlobalController {
    @Autowired
    UserService userService;

    @ModelAttribute()
    public void addUserAttributes(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            model.put("user", userService.findByLogin(authentication.getName()));
        }
    }
}
