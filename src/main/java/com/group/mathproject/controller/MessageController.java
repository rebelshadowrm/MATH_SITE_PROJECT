package com.group.mathproject.controller;

import com.group.mathproject.model.Message;
import com.group.mathproject.exception.NotFoundException;
import com.group.mathproject.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getMessages() {
        return ResponseEntity.ok().body(messageService.getMessages());
    }

    @GetMapping("/messages/{id}")
    public Message getMessageById(@PathVariable("id") Integer id) {
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
    public Message updateMessage(@PathVariable("id") Integer id,
                                 @RequestBody @NotNull Message newMsg) {
        Message msg = messageService.findById(id)
                                    .orElseThrow(()->new NotFoundException(
                                            "Message with "+id+" is Not Found!"
                                    ));
        msg.setMessage(newMsg.getMessage());
        return messageService.saveMessage(msg);
    }

    @DeleteMapping("/messages/{id}")
    public String deleteMessage(@PathVariable("id") Integer id) {
        Message msg = messageService.findById(id)
                                    .orElseThrow(()->new NotFoundException(
                                            "Message with "+id+" is Not Found!"
                                    ));
        messageService.deleteById(msg.getId());
        return "Message with ID: "+id+" is deleted";
    }

}
