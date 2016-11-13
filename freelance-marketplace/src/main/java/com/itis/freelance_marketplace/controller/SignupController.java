package com.itis.freelance_marketplace.controller;

import com.itis.freelance_marketplace.entity.Role;
import com.itis.freelance_marketplace.entity.User;
import com.itis.freelance_marketplace.service.RoleService;
import com.itis.freelance_marketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created by alt on 13.11.16.
 */
@Controller
public class SignupController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getSignup() {

        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup( @RequestParam(value="login", required=true) String login,
                          @RequestParam(value="password", required=true) String password,
                          @RequestParam(value="email", required=true) String email,
                          @RequestParam(value="role", required=true) String roleParam) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setLogin(login);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);

        ArrayList<Role> roles = new ArrayList<Role>();

        Role roleUser = roleService.findByName("ROLE_USER");
        Role role = roleService.findByName(roleParam);

        roles.add(roleUser);
        roles.add(role);

        user.setRoles(roles);

        userService.create(user);

        return "redirect:/";
    }
}
