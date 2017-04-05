package com.hucet.todoservice.domain;

import com.hucet.todo.model.TodoItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Document
@Getter
@Setter
@NoArgsConstructor
public class TodoEvent extends AuditEvent {

    public enum EventType {
        CREATE
    }

    @Id
    private UUID id = UUID.randomUUID();

    private EventType event_type;

    private TodoItem todoItem;

    public TodoEvent(EventType event_type, TodoItem item) {
        this.event_type = event_type;
        this.todoItem = item;
    }
}
