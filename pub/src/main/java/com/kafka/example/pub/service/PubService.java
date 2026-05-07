package com.kafka.example.pub.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.example.pub.model.JsonMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class PubService {

    private final KafkaTemplate<String, String> producerTemplate;
    private final ObjectMapper objectMapper;

    public void send(String eventMessage) {
        log.info("Enviando mensagem...");
        JsonMessage jsonMessage = (JsonMessage) jsonToObject(eventMessage);

        producerTemplate.send(new GenericMessage<>(objectToJNode(jsonMessage.toString())));
    }

    private Object jsonToObject(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, (Class<?>) JsonMessage.class);
        } catch (JsonProcessingException e) {
            log.error("Erro ao converter JSON para objeto: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private JsonNode objectToJNode(String jsonString) {
        return objectMapper.valueToTree(jsonString);
    }

}
