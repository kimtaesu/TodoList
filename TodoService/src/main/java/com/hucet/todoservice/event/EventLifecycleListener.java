package com.hucet.todoservice.event;

import com.hucet.todoservice.domain.TodoEvent;
import com.hucet.todoservice.stream.EventNotifyStream;
import com.hucet.todoservice.stream.dto.EventModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventLifecycleListener extends AbstractMongoEventListener<TodoEvent> {

    @Autowired
    EventNotifyStream eventNotifyStream;

    @Override
    public void onAfterSave(AfterSaveEvent<TodoEvent> event) {
        super.onAfterSave(event);

        eventNotifyStream.notifyEvent(event.getSource());
    }
}