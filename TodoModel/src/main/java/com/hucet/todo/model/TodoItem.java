package com.hucet.todo.model;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by taesu on 2017-04-05.
 */
public class TodoItem implements Serializable {
    private String uuid;
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TodoItem() {

    }

    public TodoItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "uuid='" + uuid + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
