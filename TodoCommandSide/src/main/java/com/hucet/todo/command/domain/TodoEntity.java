package com.hucet.todo.command.domain;


import com.hucet.todo.command.trigger.TodoEntityListener;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;


@Data
@Entity
@EntityListeners(TodoEntityListener.class)
public class TodoEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
}
