package com.hucet.todo.controller.service;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.hucet.remote.CreationActor;
import com.hucet.remote.Multiply;
import com.hucet.remote.TodoActor;
import com.hucet.remote.command.TodoCreateCmd;
import com.hucet.todo.model.TodoItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TodoService {
    @Autowired
    ActorSystem actorSystem;

    public void createTodoActor(TodoItem item) {
//        ActorRef createActor = actorSystem.actorOf(Props.create(TodoActor.class), "creationActor");
//        createActor.tell(new TodoCreateCmd(item), createActor);
    }
}
