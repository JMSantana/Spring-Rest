package com.springrest.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.springrest.entity.Todo;

/**
 * CrudInterfaceImpl.
 *
 *
 */
public class CrudInterfaceImpl implements CrudInterface<Todo> {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void create(Todo todo) throws Exception {

        mongoOperations.save(todo);
    }

    @Override
    public List<Todo> retrieve() throws Exception {
        return mongoOperations.findAll(Todo.class);
    }

    @Override
    public void update(Todo todo) throws Exception {
        Query searchTodoQuery = new Query(Criteria.where("id").is(todo.getId()));
        mongoOperations.updateFirst(searchTodoQuery, Update.update("todo", todo.getTodo()), Todo.class);
    }

    @Override
    public void delete(String id) throws Exception {
        Query searchUserQuery = new Query(Criteria.where("id").is(id));
        mongoOperations.remove(searchUserQuery, Todo.class);
    }
}
