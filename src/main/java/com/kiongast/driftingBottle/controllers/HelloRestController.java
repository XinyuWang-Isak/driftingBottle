package com.kiongast.driftingBottle.controllers;


import com.kiongast.driftingBottle.models.Message;
import com.kiongast.driftingBottle.models.MessageSentResponse;
import com.kiongast.driftingBottle.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/hello")
public class HelloRestController {

    private ChatService chatService;

    @PostMapping("/{id}/{ll}")
    public @ResponseBody ResponseEntity<MessageSentResponse> hello(@RequestBody Message body, HttpServletRequest request, HttpServletResponse response,
                                                                   @PathVariable("id") String id, @PathVariable("ll") String ll){
        System.out.println(id+ll);
        response.addCookie(new Cookie("cookie1","miamic1"));
        return new ResponseEntity<MessageSentResponse>(new MessageSentResponse(false), HttpStatus.OK);
    }

    @Autowired
    public void setChatService(ChatService chatService) {
        this.chatService = chatService;
    }

}
