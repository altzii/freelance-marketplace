package com.itis.freelance_marketplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by alt on 14.02.17.
 */
@Controller
public class ErrorController {
    @RequestMapping(value = "/error404", method = RequestMethod.GET)
    public String error404() {
        return "404";
    }

    @RequestMapping(value = "/error403", method = RequestMethod.GET)
    public String error403() {
        return "403";
    }
}
