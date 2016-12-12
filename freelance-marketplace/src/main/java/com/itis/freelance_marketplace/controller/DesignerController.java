package com.itis.freelance_marketplace.controller;

import com.itis.freelance_marketplace.entity.Role;
import com.itis.freelance_marketplace.repository.UserRepository;
import com.itis.freelance_marketplace.service.RoleService;
import com.itis.freelance_marketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by alt on 12.12.16.
 */
@Controller
public class DesignerController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/designers", method = RequestMethod.GET)
    public String getDesigners(ModelMap modelMap){
        Role role = roleService.findByName("ROLE_DESIGNER");

        modelMap.put("designers", userRepository.findAllByRole(role));

        return "designers";
    }
}
