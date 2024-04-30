package com.sampleserver.samplewebsocketproject.controller;

import com.sampleserver.samplewebsocketproject.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;


@Controller
@CrossOrigin
public class ChatController {

    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message") //app/message
    @SendTo("/chatroom/public")
    private Message receivedPublicMessage(@Payload Message message){
        return message;
    }

    @MessageMapping("/private-message")
    public Message receivedPrivateMessage(@Payload Message message){
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message);
        return message;
    }
}

