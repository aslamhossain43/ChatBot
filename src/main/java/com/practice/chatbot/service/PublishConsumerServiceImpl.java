package com.practice.chatbot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.chatbot.dto.User;
import com.practice.chatbot.enums.TopicName;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author Md. Aslam Hossain
 * @Date Nov 06, 2024
 */
@Slf4j
@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class PublishConsumerServiceImpl implements PublishConsumerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @Override
    public void publish(TopicName topicName, User user) throws JsonProcessingException {
        log.info("ChatBot publish method is called");
        ObjectMapper objectMapper = new ObjectMapper();
        String userString = objectMapper.writeValueAsString(user);
        kafkaTemplate.send(TopicName.TOPIC_1.getText(), userString);
    }

    @Override
    public void consume(TopicName topicName, String userString) {
        log.info("ChatBot consume method is called");
        simpMessagingTemplate.convertAndSend("/" + topicName.getText() + "/public", userString); // Send userString by this path
    }
}
