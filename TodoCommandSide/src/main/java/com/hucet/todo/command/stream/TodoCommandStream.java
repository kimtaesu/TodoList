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
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableBinding({TodoCommandStream.TodoCommandInput.class, TodoCommandStream.TodoCommandOutput.class})
public class TodoCommandStream {
    public interface TodoCommandInput {
        String INPUT = "input-res-created";

        @Input(TodoCommandInput.INPUT)
        SubscribableChannel input();
    }

    public interface TodoCommandOutput {
        String OUTPUT = "output-req-create";

        @Output(TodoCommandOutput.OUTPUT)
        MessageChannel output();
    }

    @Autowired
    TodoService todoService;

    @StreamListener(TodoCommandInput.INPUT)
    @SendTo(TodoCommandOutput.OUTPUT)
    TodoItem onTodoCreated(TodoItem item) {
        todoService.createTodo(item);
        return item;
    }
}
