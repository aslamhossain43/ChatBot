package com.practice.chatbot.controller;

import com.practice.chatbot.dto.User;
import com.practice.chatbot.enums.TopicName;
import com.practice.chatbot.service.PublishConsumerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Md. Aslam Hossain
 * @Date Nov 01, 2024
 */
@Slf4j
@RestController
@RequestMapping("/api/chatbot")
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class ChatBotRestController {

    private final PublishConsumerService publishConsumerService;

    @MessageMapping("/send")
    @SendTo("/topic-1/public")
    private String sendMessage(@RequestBody User user) {
        try {
            log.info("ChatBot rest api is called");
            publishConsumerService.publish(TopicName.TOPIC_1, user);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "User published";
    }
}
