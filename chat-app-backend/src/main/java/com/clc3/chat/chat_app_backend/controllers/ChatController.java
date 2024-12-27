package com.clc3.chat.chat_app_backend.controllers;

import com.clc3.chat.chat_app_backend.entities.Message;
import com.clc3.chat.chat_app_backend.entities.Room;
import com.clc3.chat.chat_app_backend.payload.MessageRequest;
import com.clc3.chat.chat_app_backend.services.RoomService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/rooms")
@CrossOrigin("http://localhost:3000")

public class ChatController {
    private final RoomService roomService;

    public ChatController(RoomService roomService) {
        this.roomService = roomService;
    }

    // for sending and receiving message
    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public Message sendMessage(
            @DestinationVariable String roomId,
            @RequestBody MessageRequest messageRequest
    ){

        Room room = roomService.getRoom(roomId);
        Message message = new Message();
        message.setContent(messageRequest.getContent());
        message.setSender(messageRequest.getSender());
        message.setTimestamp(LocalDateTime.now());
        if(room!=null){
           room.getMessages().add(message);
           roomService.updateRoom(room);
           return  message;
        }
        else throw new RuntimeException("Room Not found");
    }
}
