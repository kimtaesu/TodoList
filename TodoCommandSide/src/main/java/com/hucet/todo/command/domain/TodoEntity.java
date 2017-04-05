package com.hucet.todo.command.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class TodoEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String title = "Dummy " + UUID.randomUUID();
    private String desc;
}
