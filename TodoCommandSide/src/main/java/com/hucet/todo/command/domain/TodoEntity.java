package com.hucet.todo.command.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;


@Data
@Entity
public class TodoEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
}
