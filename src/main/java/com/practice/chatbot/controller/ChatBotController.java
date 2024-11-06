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

    @RequestMapping("")
    private String showChatbot() {
        try {
            log.info("Chatbot view page is called");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "chatbot-user-1";
    }
}
