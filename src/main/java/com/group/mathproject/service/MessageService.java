package com.group.mathproject.service;

import com.group.mathproject.model.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    Message saveMessage(Message msg);
    List<Message> getMessages();
    Optional<Message> findById(Integer id);
    void deleteById(Integer id);
}
