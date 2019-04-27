package com.yatish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import com.yatish.model.Item;


@RestController
@RequestMapping("producer")
public class HelloController {

    @Autowired
    KafkaTemplate<String, Item> KafkaJsontemplate;
    String TOPIC_NAME = "items-topic";

    @PostMapping(value = "/postItem",consumes = {"application/json"},produces = {"application/json"})
    public String postJsonMessage(@RequestBody Item item){
        //KafkaJsontemplate.send(TOPIC_NAME,new Item(1,"Lenovo","Laptop"));
    	KafkaJsontemplate.send(TOPIC_NAME,item);
        return "Message published successfully";
    }
}
