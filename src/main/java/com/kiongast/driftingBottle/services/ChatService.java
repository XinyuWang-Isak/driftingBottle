package com.kiongast.driftingBottle.services;

import com.kiongast.driftingBottle.exceptions.MessageReceivedErrorException;
import com.kiongast.driftingBottle.exceptions.MessageSentErrorException;
import com.kiongast.driftingBottle.models.AppUser;
import com.kiongast.driftingBottle.models.Message;
import com.kiongast.driftingBottle.repos.AppUserRepository;
import com.kiongast.driftingBottle.repos.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ChatService {

    private AppUserRepository appUserRepository;
    private MessageRepository messageRepository;

    public String hello(){
        return "Count: "+ appUserRepository.count() + messageRepository.count();
    }

    @Autowired
    public void setAppUserRepository(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Autowired
    public void setMessageRepository(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public void sendMessage(Message message) throws MessageSentErrorException {
        boolean senderExists = message.getSender() != null && appUserRepository.existsById(message.getSender().getId());
        boolean receiverExists = message.getReceiver() != null && appUserRepository.existsById(message.getReceiver().getId());
        if (!senderExists || !receiverExists){
            throw new MessageSentErrorException("Invalid user(s).");
        }
        if (!StringUtils.hasText(message.getContent())){
            throw new MessageSentErrorException("Invalid message content.");
        }
        message.setCreateTime(System.currentTimeMillis());
        messageRepository.save(message);
    }

    public List<Message> getFirst10Messages(AppUser appUser) throws MessageReceivedErrorException {
        boolean userExists = appUser.getId() == null && appUserRepository.existsById(appUser.getId());
        if (! userExists) {
            throw new MessageReceivedErrorException("Invalid user(s)");
        }
        return  messageRepository.findFirst10BySender(appUser);
    }
}
