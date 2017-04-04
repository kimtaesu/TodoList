package com.hucet.todoservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by taesu on 2017-04-04.
 */
@Data
@ToString
public class TodoItem implements Serializable {
    private String title;
    private String desc;
    private boolean isCompleted = false;

    private TodoDetail todoDetail;
}
