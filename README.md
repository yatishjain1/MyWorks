# MyWorks

1. create topic
      .\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic items-topic
2. create consumer for command prompt
       .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic items-topic --from-beginning
3. Run the spring boot application

4. Test with postman .Sample code below
  
       POST /producer/postItem HTTP/1.1
      Host: localhost:8080
      Content-Type: application/json
      cache-control: no-cache
      Postman-Token: cf5f5448-d3ce-4c3c-9930-b4a2bf332a1c
      {
        "id": 2,
        "name" : "lenovo",
        "category" : "laptop"
      }------WebKitFormBoundary7MA4YWxkTrZu0gW--
