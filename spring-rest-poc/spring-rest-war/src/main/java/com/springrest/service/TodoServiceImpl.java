package com.springrest.service;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.entity.Todo;
import com.springrest.persistence.CrudInterface;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private CrudInterface<Todo> crudInterface;

    public Response addTodo(Todo todo) {
        try {
            if (todo != null && !todo.getTodo().equals("")) {
                crudInterface.create(todo);
                return Response.ok(todo, MediaType.APPLICATION_JSON).build();
            }
            return Response.serverError().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    public Response getTodos() {
        try {
            List<Todo> todos = crudInterface.retrieve();
            return Response.ok(todos, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    public Response updateTodo(Todo todo) {
        try {
            if (todo != null && !todo.getTodo().equals("") && todo.getId() != null && !todo.getId().equals("")) {
                crudInterface.update(todo);
                return Response.ok(todo, MediaType.APPLICATION_JSON).build();
            }
            return Response.serverError().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    public Response deleteTodo(String id) {
        try {
            if (id != null && !id.equals("")) {
                crudInterface.delete(id);
                return Response.ok().build();
            }
            return Response.serverError().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
