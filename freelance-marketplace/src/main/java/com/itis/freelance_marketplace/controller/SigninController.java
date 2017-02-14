package com.itis.freelance_marketplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by alt on 13.11.16.
 */
@Controller
public class SigninController {
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String getSignin(@RequestParam(value = "error", required = false) boolean error, ModelMap model) {
        if (error) {
            model.addAttribute("error", true);
        }
        return "/signin";
    }
}