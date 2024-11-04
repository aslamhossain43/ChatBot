package com.practice.chatbot.controller;

import com.practice.chatbot.enums.TopicName;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
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

    private final KafkaTemplate<String, String> kafkaTemplate;

    //    @PostMapping("/send")
    @MessageMapping("/send")
    @SendTo("/topic-1/public")
    private String sendMessage(@RequestBody String message) {
        log.info("Chatbot rest api is called");
        kafkaTemplate.send(TopicName.TOPIC_1.getText(), message);
        return "Message published";
    }
}
