package com.hucet.todo.command.stream;


import com.hucet.todo.command.service.TodoService;
import com.hucet.todo.model.TodoItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableBinding(TodoCommandStream.TodoCommandInput.class)
public class TodoCommandStream {
    public interface TodoCommandInput {
        String INPUT = "input-todo-command";

        @Input(TodoCommandInput.INPUT)
        SubscribableChannel input();
    }

    @Autowired
    TodoService todoService;

    @StreamListener(TodoCommandInput.INPUT)
    void onTodoCreated(TodoItem item) {
        todoService.createTodo(item);
    }
}
