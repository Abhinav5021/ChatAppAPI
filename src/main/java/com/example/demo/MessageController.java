package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/messages")
@CrossOrigin("*") // Allow frontend access
public class MessageController {

    @Autowired
    private MessageRepository messageRepo;

    @PostMapping("/send")
    public Message sendMessage(@RequestBody Message message) {
        message.setTimestamp(LocalDateTime.now());
        return messageRepo.save(message);
    }

    @GetMapping("/history/{user1}/{user2}")
    public List<Message> getChatHistory(@PathVariable Long user1, @PathVariable Long user2) {
        return messageRepo.findChatHistory(user1, user2);
    }
}