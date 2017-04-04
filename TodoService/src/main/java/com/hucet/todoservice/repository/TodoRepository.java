package com.hucet.todoservice.repository;

import com.hucet.todoservice.domain.TodoEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

/**
 * Created by taesu on 2017-04-04.
 */
public interface TodoRepository extends MongoRepository<TodoEvent, UUID> {
    TodoEvent save(TodoEvent todoEvent);
}
