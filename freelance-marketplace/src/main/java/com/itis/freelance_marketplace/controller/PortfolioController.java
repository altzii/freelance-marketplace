package com.itis.freelance_marketplace.controller;

import com.itis.freelance_marketplace.service.PortfolioService;
import com.itis.freelance_marketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by alt on 20.11.16.
 */
@Controller
public class PortfolioController {
    @Autowired
    PortfolioService portfolioService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/portfolios", method = RequestMethod.GET)
    public String getPortfolios(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/error403";
        } else {
            modelMap.put("portfolios", portfolioService.findAll());

            return "portfolios";
        }
    }
}
