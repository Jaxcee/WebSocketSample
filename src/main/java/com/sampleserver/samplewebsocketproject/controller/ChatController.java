package com.sampleserver.samplewebsocketproject.controller;

import com.sampleserver.samplewebsocketproject.model.Message;
import com.sampleserver.samplewebsocketproject.model.Status;
import com.sampleserver.samplewebsocketproject.repo.MessageRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private SimpMessagingTemplate simpMessagingTemplate;
    private final MessageRepository messageRepository;

    public ChatController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Message receivedPublicMessage(@Payload Message message){
        message.setStatus(Status.MESSAGE);
        return messageRepository.save(message);
    }

    @MessageMapping("/private-message")
    public Message receivedPrivateMessage(@Payload Message message){
        message.setStatus(Status.MESSAGE);
        Message savedMessage = messageRepository.save(message);
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", savedMessage);
        return savedMessage;
    }
}
