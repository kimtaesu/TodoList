package com.hucet.todoservice.stream;

import com.hucet.todoservice.domain.TodoEvent;
import com.hucet.todoservice.stream.dto.EventModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@EnableBinding(EventNotifyStream.EventSource.class)
public class EventNotifyStream {
    @Autowired
    EventSource eventSource;

    public boolean notifyEvent(TodoEvent event) {
        return eventSource.output().send(MessageBuilder.withPayload(new EventModel(event.getEvent_type().name())).build());
    }

    public interface EventSource {
        String OUTPUT = "output-event";

        @Output(EventSource.OUTPUT)
        MessageChannel output();
    }
}
