package com.practice.chatbot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.practice.chatbot.dto.User;
import com.practice.chatbot.enums.TopicName;

/**
 * @Author Md. Aslam Hossain
 * @Date Nov 06, 2024
 */
public interface PublishConsumerService {
    void publish(TopicName topicName, User user) throws JsonProcessingException;

    void consume(TopicName topicName, String userString);
}
