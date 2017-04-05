package com.hucet.todo.command.repository;


import com.hucet.todo.command.domain.TodoEntity;
import org.springframework.data.repository.Repository;

public interface TodoRepository extends Repository<TodoEntity, Long> {
    TodoEntity save(TodoEntity entity);
}
