package com.itis.freelance_marketplace.controller;

import com.itis.freelance_marketplace.entity.Role;
import com.itis.freelance_marketplace.entity.User;
import com.itis.freelance_marketplace.form.SignupForm;
import com.itis.freelance_marketplace.service.RoleService;
import com.itis.freelance_marketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
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

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getSignup(Model model) {
        model.addAttribute("signup_form", new SignupForm());

        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@ModelAttribute("signup_form") @Valid SignupForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "signup";
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setLogin(form.getLogin());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setEmail(form.getEmail());
        user.setName(form.getName());
        user.setPhone(form.getPhone());

        ArrayList<Role> roles = new ArrayList<Role>();

        Role roleUser = roleService.findByName("ROLE_USER");
        Role role = roleService.findByName(form.getRole());
        roles.add(roleUser);
        roles.add(role);

        user.setRoles(roles);

        userService.create(user);

        return "redirect:/";
    }
}
