package com.hucet.todo.model;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by taesu on 2017-04-05.
 */
public class TodoItem implements Serializable {
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
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
