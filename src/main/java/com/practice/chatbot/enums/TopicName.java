package com.practice.chatbot.enums;

/**
 * @Author Md. Aslam Hossain
 * @Date Nov 01, 2024
 */
public enum TopicName {
    TOPIC_1(1, "topic-1");
    private int value;
    private String text;

    TopicName(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
