package com.clc3.chat.chat_app_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {
    private String sender;
    private String content;
    private LocalDateTime timestamp;
}
