package com.springrest.entity;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todos")
@XmlRootElement
public class Todo extends BasePojo {

    private String todo;

    public Todo() {}

    public Todo(String todo) {
        this.todo = todo;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
}
