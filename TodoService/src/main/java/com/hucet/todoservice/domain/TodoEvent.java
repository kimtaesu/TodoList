package com.hucet.todoservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Document
@Getter
@Setter
@NoArgsConstructor
public class TodoEvent {

    public enum EventType {
        CREATE
    }

    @Id
    private UUID id = UUID.randomUUID();

    private EventType event_type;

    private Collection<TodoItem> todoitems = new ArrayList<>();

    public TodoEvent(EventType event_type, TodoItem todoitem) {
        this.event_type = event_type;
        this.todoitems.add(todoitem);
    }
    //
//    @CreatedDate
//    private DateTime createdAt;
//
//    @LastModifiedDate
//    private DateTime lastModified;
}
