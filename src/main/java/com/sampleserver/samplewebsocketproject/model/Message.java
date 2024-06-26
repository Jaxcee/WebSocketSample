package com.sampleserver.samplewebsocketproject.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Message {
    @Id
    @GeneratedValue
    private int id;
    private String message;
    private String senderName;
    private String receiverName;
    private String date;
    private Status status;
}
