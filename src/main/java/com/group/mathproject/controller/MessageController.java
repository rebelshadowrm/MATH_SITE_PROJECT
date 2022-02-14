package com.group.mathproject.controller;

import com.group.mathproject.model.Message;
import com.group.mathproject.exception.NotFoundException;
import com.group.mathproject.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    public List<Message> getMessages() {
        return messageService.getMessages();
    }

    @GetMapping("/messages/{id}")
    public Message getMessageById(@PathVariable("id") int id) {
        return messageService.findById(id)
                                    .orElseThrow(()->new NotFoundException(
                                            "Message with "+id+" is Not Found!"
                                    ));
    }

    @PostMapping("/messages")
    public Message addMessage(@RequestBody Message msg) {
        return messageService.saveMessage(msg);
    }

    @PutMapping(value="/messages/{id}")
    public Message updateMessage(@PathVariable("id") int id,
                                 @RequestBody Message newMsg) {
        Message msg = messageService.findById(id)
                                    .orElseThrow(()->new NotFoundException(
                                            "Message with "+id+" is Not Found!"
                                    ));
        msg.setMessage(newMsg.getMessage());
        return messageService.saveMessage(msg);
    }

    @DeleteMapping("/messages/{id}")
    public String deleteMessage(@PathVariable("id") int id) {
        Message msg = messageService.findById(id)
                                    .orElseThrow(()->new NotFoundException(
                                            "Message with "+id+" is Not Found!"
                                    ));
        messageService.deleteById(msg.getId());
        return "Message with ID: "+id+" is deleted";
    }

}
