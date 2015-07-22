package com.springrest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.springrest.entity.Todo;


@Path("/todo/")
@Consumes(value = "application/json")
@Produces(value = "application/json")
public interface TodoService {

    @POST
    Response addTodo(Todo todo);

    @GET
    Response getTodos();

    @PUT
    Response updateTodo(Todo todo);

    @DELETE
    @Path("{id}")
    Response deleteTodo(@PathParam("id") String id);
}
