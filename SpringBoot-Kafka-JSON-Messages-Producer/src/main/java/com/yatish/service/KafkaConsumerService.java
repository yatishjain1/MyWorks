package com.yatish.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.yatish.model.Item;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "items-topic", groupId = "sample-group",containerFactory = "kafkaListener")
    public void consume(Item item){
        System.out.println("Consumed Message :"+item);
    }
}