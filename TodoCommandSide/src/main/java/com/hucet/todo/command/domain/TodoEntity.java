package com.hucet.todo.command.domain;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class TodoEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
}
