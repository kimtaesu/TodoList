package com.hucet.todoservice.stream.dto;

import com.hucet.todoservice.domain.TodoEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.annotation.sql.DataSourceDefinition;

@Getter
@AllArgsConstructor
public class EventModel {
    private String eventType;

}
