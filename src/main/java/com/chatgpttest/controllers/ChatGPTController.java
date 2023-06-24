package com.chatgpttest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatgpttest.services.ChatGPTService;

@RestController
public class ChatGPTController {

    @Autowired
    private ChatGPTService chatGPTService;

    @GetMapping("/chat-with-chat-gpt")
    public String chat(@RequestParam String query) {
        try {
            return chatGPTService.fetchChatResponse(query);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
