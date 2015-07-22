package com.springrest.entity;

import org.springframework.data.annotation.Id;

public class BasePojo {

    @Id
    private String id;

    public BasePojo() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
