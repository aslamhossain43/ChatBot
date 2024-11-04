package com.practice.chatbot.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author Md. Aslam Hossain
 * @Date Nov 01, 2024
 */
@Slf4j
@Component
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class KafkaListenerConfig {
    private final SimpMessagingTemplate simpMessagingTemplate;

    @KafkaListener(topics = "topic-1", groupId = "group-1")
    void listener(String message) {
        log.info("Received message [{}] in group1", message);
        simpMessagingTemplate.convertAndSend("/topic-1/public", message); // Send message by this path
    }
}
