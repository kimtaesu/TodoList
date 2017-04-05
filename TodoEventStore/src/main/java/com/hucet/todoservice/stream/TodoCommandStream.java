package com.hucet.todoservice.stream;

import com.hucet.todoservice.domain.TodoEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@EnableBinding(TodoCommandStream.TodoCommandSource.class)
public class TodoCommandStream {

    public interface TodoCommandSource {
        String OUTPUT = "output-todo-command";

        @Output(TodoCommandSource.OUTPUT)
        MessageChannel output();
    }

    @Autowired
    TodoCommandSource todoCommandSource;

    public boolean notifyEvent(TodoEvent event) {
        return todoCommandSource.output().send(MessageBuilder.withPayload(event.getTodoItem()).build());
    }
}
