package com.mywork.SpringBatch.config;

import java.util.List;
 
import org.springframework.batch.item.ItemWriter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
/*import org.springframework.web.client.RestTemplate;*/
import org.springframework.web.client.RestTemplate;

import com.mywork.SpringBatch.model.Item;
 
public class ConsoleItemWriter<T> implements ItemWriter<T> {
    //@Override
    public void write(List<? extends T> items) throws Exception {
        for (T item : items) {
          
            Item itemNew = (Item)item;
            System.out.println(itemNew);
            final String uri = "http://localhost:8080/producer/postItem";
            
            HttpHeaders headers = new HttpHeaders();
         
            HttpEntity<Item> request = new HttpEntity<Item>(itemNew, headers);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
         
            System.out.println(result);
            
        }
    }
}