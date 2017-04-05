package com.hucet.todo.command.trigger;

import com.hucet.todo.command.domain.TodoEntity;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.PostPersist;

@Slf4j
public class TodoEntityListener {
    @PostPersist
    void onPost(final TodoEntity entity)
    {
        log.info("onPost");
    }
}
