package com.kiongast.driftingBottle.controllers;

import com.kiongast.driftingBottle.exceptions.MessageReceivedErrorException;
import com.kiongast.driftingBottle.exceptions.MessageSentErrorException;
import com.kiongast.driftingBottle.models.AppUser;
import com.kiongast.driftingBottle.models.Message;
import com.kiongast.driftingBottle.models.MessageReceivedResponse;
import com.kiongast.driftingBottle.models.MessageSentResponse;
import com.kiongast.driftingBottle.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {
    private ChatService chatService;

    @Autowired
    public void setChatService(ChatService chatService) {
        this.chatService = chatService;
    }

    @PutMapping("/send")
    public @ResponseBody
    ResponseEntity<MessageSentResponse> sendMessage(@RequestBody Message message) throws MessageSentErrorException {
        chatService.sendMessage(message);
        return new ResponseEntity<MessageSentResponse>(new MessageSentResponse("Message sent successfully!",true), HttpStatus.OK);

    }

    @GetMapping("/getMessages")
    public ResponseEntity<MessageReceivedResponse> getInitialMessges(@RequestBody AppUser appUser) throws MessageReceivedErrorException {

        return new ResponseEntity<MessageReceivedResponse>
                (new MessageReceivedResponse("Message received successfully! ",
                        chatService.getFirst10Messages(appUser),true), HttpStatus.OK);
    }

    @ExceptionHandler(MessageSentErrorException.class)
    public ResponseEntity<MessageSentResponse> handleMessageSentErrorException(
            MessageSentErrorException exception){
        return new ResponseEntity<MessageSentResponse>(new MessageSentResponse(exception.getMessage(),false), HttpStatus.BAD_REQUEST);
    }



}
