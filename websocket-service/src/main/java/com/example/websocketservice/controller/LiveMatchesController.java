package com.example.websocketservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @date: 2021/5/10 17:21:57
 * @author: liuchunchi
 */
@Slf4j
@RestController
public class LiveMatchesController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;


    @MessageMapping("/chat")
    @SendTo("/toAll/matches")
    public void matches() {

        messagingTemplate.convertAndSend("/matches/test", "hell world");//这个也是重点（点对点）
    }


    @GetMapping("/matches/test")
    public void test(String text) {
        log.info(text);
    }

}
