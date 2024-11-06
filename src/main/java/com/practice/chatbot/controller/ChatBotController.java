package com.practice.chatbot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Md. Aslam Hossain
 * @Date Nov 01, 2024
 */
@Slf4j
@Controller
@RequestMapping("/chatbot")
public class ChatBotController {

    @RequestMapping("/user/1")
    private String showChatbotForUser1() {
        try {
            log.info("ChatBot view page is called for user 1");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "chatbot-user-1";
    }

    @RequestMapping("/user/2")
    private String showChatbotForUser2() {
        try {
            log.info("ChatBot view page is called for user 2");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "chatbot-user-2";
    }
}
