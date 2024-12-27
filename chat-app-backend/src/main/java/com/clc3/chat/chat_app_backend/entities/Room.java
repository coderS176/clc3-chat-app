package com.clc3.chat.chat_app_backend.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collation = "rooms")
public class Room {
    @Id
    private String id;
    private String roomId;
    private List<Message> messages = new ArrayList<>();
}