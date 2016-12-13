package com.itis.freelance_marketplace.controller;

import com.itis.freelance_marketplace.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/portfolios", method = RequestMethod.GET)
    public String getPortfolios(ModelMap modelMap) {
        modelMap.put("portfolios", portfolioService.findAll());

        return "portfolios";
    }
}
