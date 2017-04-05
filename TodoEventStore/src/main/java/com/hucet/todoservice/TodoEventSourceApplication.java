package com.hucet.todoservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
@Slf4j
public class TodoEventSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoEventSourceApplication.class, args);
    }

}
