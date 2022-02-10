package com.group.mathproject.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    public Optional<Message> findById(int id) {
        return messageRepository.findById(id);
    }

    public Message saveMessage(Message msg) {
        return messageRepository.save(msg);
    }

    public void deleteById(int id) {
        messageRepository.deleteById(id);
    }

}
