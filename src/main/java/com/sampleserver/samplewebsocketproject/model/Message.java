package com.sampleserver.samplewebsocketproject.model;


import lombok.Data;

@Data
public class Message {

    private String message;
    private String senderName;
    private String receiverName;
    private String date;
    private Status status;
}
