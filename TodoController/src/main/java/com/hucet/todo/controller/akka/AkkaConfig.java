package com.hucet.todo.controller.akka;

import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.rmi.Remote;

@Configuration
public class AkkaConfig {
    @Bean
    ActorSystem actorSystemBean() {
        return ActorSystem.create("RemoteNodeApp", ConfigFactory
                .load("remotecreation"));
    }
}
