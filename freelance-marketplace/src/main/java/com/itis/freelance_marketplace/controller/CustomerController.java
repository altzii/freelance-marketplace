package com.itis.freelance_marketplace.controller;

import com.itis.freelance_marketplace.entity.Role;
import com.itis.freelance_marketplace.service.RoleService;
import com.itis.freelance_marketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by alt on 13.12.16.
 */
@Controller
public class CustomerController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String getCustomers(ModelMap modelMap){
        Role role = roleService.findByName("ROLE_CUSTOMER");

        modelMap.put("customers", userService.findAllByRole(role));

        return "customers";
    }
}
