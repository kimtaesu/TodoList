package com.hucet.todoservice.service;

import com.hucet.todoservice.domain.TodoEvent;
import com.hucet.todoservice.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public TodoEvent putTodo(TodoEvent dto) {
        return todoRepository.save(dto);
    }
}
