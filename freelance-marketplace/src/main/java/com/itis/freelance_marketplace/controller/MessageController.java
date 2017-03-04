package com.itis.freelance_marketplace.controller;

import com.itis.freelance_marketplace.entity.Message;
import com.itis.freelance_marketplace.entity.User;
import com.itis.freelance_marketplace.security.CustomUserDetails;
import com.itis.freelance_marketplace.service.MessageService;
import com.itis.freelance_marketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;

/**
 * Created by alt on 14.11.16.
 */
@Controller
public class MessageController {
    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    Authentication authentication;

    User currentUser;

    @RequestMapping(value = "/conversation", method = RequestMethod.GET)
    public String getConversation(ModelMap modelMap, @RequestParam(value = "id", required = true) long id) {
        authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = userService.findById(id);

        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/error403";
        } else if (user == null) {
            return "redirect:/error404";
        } else {
            currentUser = ((CustomUserDetails) authentication.getPrincipal()).getUser();

            modelMap.put("messages", messageService.findAllMessagesByUsersOrderByDate(currentUser, user));
            modelMap.put("to_id", user.getId());
            modelMap.put("to_user", user);

            return "messages";
        }
    }

    @RequestMapping(value = "/send_message/{id:\\d+}", method = RequestMethod.POST)
    public String sendMessage(@PathVariable("id") long id, @RequestParam("text") String text) {
        authentication = SecurityContextHolder.getContext().getAuthentication();

        User toUser = userService.findById(id);

        if (toUser == null) {
            return "redirect:/error404";
        } else {
            currentUser = ((CustomUserDetails) authentication.getPrincipal()).getUser();

            Message message = new Message();
            message.setText(text);
            message.setDate(new Timestamp(System.currentTimeMillis()));
            message.setFromUser(currentUser);
            message.setToUser(toUser);

            messageService.create(message);

            return "redirect:/conversation?id=" + id;
        }
    }
}
