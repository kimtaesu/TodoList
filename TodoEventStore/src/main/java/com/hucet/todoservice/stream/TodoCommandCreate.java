package com.hucet.todoservice.stream;

import com.hucet.todo.model.TodoItem;
import com.hucet.todoservice.domain.TodoEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding({TodoCommandCreate.TodoResCreated.class, TodoCommandCreate.TodoReqCreate.class})
@Slf4j
public class TodoCommandCreate {
    public interface TodoResCreated {
        String INPUT = "input-res-created";

        @Input(TodoCommandCreate.TodoResCreated.INPUT)
        SubscribableChannel input();
    }

    public interface TodoReqCreate {
        String OUTPUT = "output-req-create";

        @Output(TodoCommandCreate.TodoReqCreate.OUTPUT)
        MessageChannel output();
    }

    @Autowired
    TodoCommandCreate.TodoReqCreate send;

    public boolean sendCreate(TodoEvent event) {
        event.getId().hashCode();
        return send.output().send(MessageBuilder.withPayload(event.getTodoItem()).build());
    }

    @StreamListener(TodoResCreated.INPUT)
    void onReceiveCreated(TodoItem item) {
        log.info("onReceiveCreated " + item.toString());
    }
}
