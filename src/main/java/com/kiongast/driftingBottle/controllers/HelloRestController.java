package com.kiongast.driftingBottle.controllers;


import com.kiongast.driftingBottle.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    private ChatService chatService;

    @GetMapping("/hello")
    public String hello(){
        return chatService.hello();
    }

    @Autowired
    public void setChatService(ChatService chatService) {
        this.chatService = chatService;
    }

}
