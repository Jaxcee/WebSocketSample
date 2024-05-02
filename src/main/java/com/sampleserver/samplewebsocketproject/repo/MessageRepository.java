package com.sampleserver.samplewebsocketproject.repo;

import com.sampleserver.samplewebsocketproject.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {


}