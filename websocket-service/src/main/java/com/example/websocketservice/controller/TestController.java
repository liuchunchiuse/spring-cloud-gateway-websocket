package com.example.websocketservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @date: 2021/5/11 16:40:41
 * @author: liuchunchi
 */
@RestController
@RequestMapping("lcc")
@Slf4j
public class TestController {

    @GetMapping("/get")
    public String get() {
        log.info("4");
        return "4";
    }


}
