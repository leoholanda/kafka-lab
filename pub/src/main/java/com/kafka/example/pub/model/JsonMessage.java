package com.kafka.example.pub.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class JsonMessage {
    private String key;
    private String message;
}
