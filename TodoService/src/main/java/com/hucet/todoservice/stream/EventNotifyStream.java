package com.hucet.todoservice.stream;

import com.hucet.todoservice.stream.dto.Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@EnableBinding(EventNotifyStream.EventSource.class)
public class EventNotifyStream {
    @Autowired
    EventSource eventSource;

    public boolean notifyEvent(Test test) {
        boolean is = eventSource.output().send(MessageBuilder.withPayload(test).build());
        log.info("!!!!!!!!!!!!!!1" + is);
        return is;
    }

    public interface EventSource {
        String OUTPUT = "output-event";

        @Output(EventSource.OUTPUT)
        MessageChannel output();
    }
}
