package com.hucet.todo.controller.contoller;

import com.hucet.todo.controller.service.TodoService;
import com.hucet.todo.model.TodoItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class TodoController {
    @Autowired
    TodoService todoService;

    @RequestMapping(value = "/create", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String createTodo(@RequestBody TodoItem item) {
        todoService.createTodoActor(item);
        return "Test";
    }
}
