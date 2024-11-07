package com.practice.chatbot.dto;

import com.practice.chatbot.enums.MessageType;
import lombok.Builder;
import lombok.Data;

/**
 * @Author Md. Aslam Hossain
 * @Date Nov 06, 2024
 */
@Data
@Builder
public class User {
    private String username;
    private String message;
    private MessageType messageType;
}
