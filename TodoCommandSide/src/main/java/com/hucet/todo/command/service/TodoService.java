package com.hucet.todo.command.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hucet.todo.command.domain.TodoEntity;
import com.hucet.todo.command.repository.TodoRepository;
import com.hucet.todo.model.TodoItem;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class TodoService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    TodoRepository todoRepository;

    public TodoEntity createTodo(TodoItem item) {
        TodoEntity entity = modelMapper.map(item, TodoEntity.class);
        return todoRepository.save(entity);
    }
}
