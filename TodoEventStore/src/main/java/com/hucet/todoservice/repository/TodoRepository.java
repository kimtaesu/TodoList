package com.hucet.todoservice.repository;

import com.hucet.todoservice.domain.TodoEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface TodoRepository extends MongoRepository<TodoEvent, UUID> {
    TodoEvent save(TodoEvent todoEvent);
}
