package com.hucet.todoservice.controller;

import com.hucet.todo.model.TodoItem;
import com.hucet.todoservice.domain.TodoEvent;
import com.hucet.todoservice.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TodoContoller {
    @Autowired
    TodoService todoService;

    @RequestMapping(value = "/create", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<String> createTodo(@RequestBody TodoItem item) {
        TodoEvent todoEvent = new TodoEvent(TodoEvent.EventType.CREATE, item);
        todoService.createTodo(todoEvent);
        return null;
    }
}
