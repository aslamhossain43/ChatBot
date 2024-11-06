package com.practice.chatbot.config;

import com.practice.chatbot.enums.TopicName;
import com.practice.chatbot.service.PublishConsumerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author Md. Aslam Hossain
 * @Date Nov 01, 2024
 */
@Slf4j
@Component
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class KafkaListenerConfig {
    private final PublishConsumerService publishConsumerService;

    @KafkaListener(topics = "topic-1", groupId = "group-1")
    void listener(String userString) {
        try {
            log.info("Received userString [{}] in group1", userString);
            publishConsumerService.consume(TopicName.TOPIC_1, userString);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
