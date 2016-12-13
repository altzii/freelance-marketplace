package com.itis.freelance_marketplace.service;

import com.itis.freelance_marketplace.entity.Message;
import com.itis.freelance_marketplace.entity.User;

import java.util.List;

/**
 * Created by alt on 14.11.16.
 */
public interface MessageService {
    Message create(Message message);

    Message delete(long id);

    List<Message> findAll();

    List<Message> findAllMessagesByUsers(User userFrom, User userTo);

    Message update(Message message);

    Message findById(long id);
}
