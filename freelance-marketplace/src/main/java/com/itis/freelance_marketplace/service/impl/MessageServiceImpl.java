package com.itis.freelance_marketplace.service.impl;

import com.itis.freelance_marketplace.entity.Message;
import com.itis.freelance_marketplace.entity.User;
import com.itis.freelance_marketplace.repository.MessageRepository;
import com.itis.freelance_marketplace.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alt on 14.11.16.
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepository messageRepository;

    @Override
    @Transactional
    public Message create(Message message) {
        return messageRepository.save(message);
    }

    @Override
    @Transactional
    public Message delete(long id) {
        Message message = messageRepository.findOne(id);
        messageRepository.delete(message);
        return message;
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> findAllMessagesByUsersOrderByDate(User userFrom, User userTo) {
        return messageRepository.findAllMessagesByUsersOrderByDate(userFrom, userTo);
    }

    @Override
    @Transactional
    public Message update(Message message) {
        return messageRepository.saveAndFlush(message);
    }

    @Override
    public Message findById(long id) {
        return messageRepository.findOne(id);
    }
}
