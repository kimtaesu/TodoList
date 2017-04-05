package com.hucet.todo.retrive.stream;

import com.hucet.todo.retrive.stream.dto.EventModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@EnableBinding(EventReceiver.EventSink.class)
public class EventReceiver {
    public interface EventSink {
        String INPUT = "input-event";

        @Input(EventSink.INPUT)
        SubscribableChannel input();
    }

    @StreamListener(EventSink.INPUT)
    void eventReceive(EventModel eventModel) {
        log.info(eventModel.toString());
    }
}
