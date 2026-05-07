package com.kafka.example.pub.controller;

import com.kafka.example.pub.service.PubService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class PubController {

    private final PubService pubService;

    @PostMapping("/publish/text")
    public void publishText(@RequestBody String text) {
        pubService.send(text);
    }

}
