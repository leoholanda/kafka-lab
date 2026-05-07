package com.kafka.example.sub.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.example.sub.model.JsonMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class SubService {

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "MY.TEST.TOPIC.1", groupId = "my-group-id")
    public void consume(String eventMessage) throws JsonProcessingException {
       log.info("Mensagem recebida: {}", eventMessage);

//        JsonNode jsonMessage = objectMapper.readTree(eventMessage);
//        JsonMessage message = objectMapper.treeToValue(jsonMessage, JsonMessage.class);

//        log.info("Mensagem: {}", message.toString());
    }


}
