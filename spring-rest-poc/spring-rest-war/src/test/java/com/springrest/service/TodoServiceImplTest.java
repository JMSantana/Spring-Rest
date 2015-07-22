package com.springrest.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import com.springrest.WebApplicationContextConfiguration;
import com.springrest.entity.Todo;
import com.springrest.persistence.CrudInterface;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = WebApplicationContextConfiguration.class)
@SuppressWarnings("unchecked")
public class TodoServiceImplTest {

    @Mock
    CrudInterface<Todo> crudInterface;

    @InjectMocks
    private TodoServiceImpl todoServiceImpl = new TodoServiceImpl();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldRetrieveTodos() throws Exception {
        // given
        List<Todo> todos = new ArrayList<Todo>();
        todos.add(new Todo("test1"));
        todos.add(new Todo("test2"));

        // and
        given(crudInterface.retrieve()).willReturn(todos);

        // when:
        Response resp = todoServiceImpl.getTodos();

        // then:
        assertEquals(resp.getStatus(), Response.Status.OK.getStatusCode());

        // and
        List<Todo> result = (ArrayList<Todo>) resp.getEntity();
        assertEquals(resp.getStatus(), Response.Status.OK.getStatusCode());
        assertEquals(result.get(0).getTodo(), "test1");
        assertEquals(result.get(1).getTodo(), "test2");
    }

    @Test
    public void shouldRetrieveEmptyListOfTodos() throws Exception {
        // given
        List<Todo> todos = new ArrayList<Todo>();

        // and
        given(crudInterface.retrieve()).willReturn(todos);

        // when:
        Response resp = todoServiceImpl.getTodos();

        // then:
        assertEquals(resp.getStatus(), Response.Status.OK.getStatusCode());

        // and
        List<Todo> result = (ArrayList<Todo>) resp.getEntity();
        assertEquals(resp.getStatus(), Response.Status.OK.getStatusCode());
        assertEquals(result.size(), 0);
    }

    @Test
    public void shouldFailIfTodoIsNullWhenAdding() {
        // given:
        Todo todo = null;

        // when:
        Response resp = todoServiceImpl.addTodo(todo);

        // then:
        assertEquals(resp.getStatus(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    }

    @Test
    public void shouldFailIfTodoIsEmptyWhenAdding() {
        // given:
        Todo todo = new Todo("");

        // when:
        Response resp = todoServiceImpl.addTodo(todo);

        // then:
        assertEquals(resp.getStatus(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    }

    @Test
    public void shouldAddTodo() throws Exception {
        // given:
        Todo todo = new Todo("test");

        // when:
        Response resp = todoServiceImpl.addTodo(todo);

        // then
        verify(crudInterface, times(1)).create(todo);

        // and
        Todo result = (Todo) resp.getEntity();

        // and
        assertEquals(resp.getStatus(), Response.Status.OK.getStatusCode());
        assertEquals(result.getTodo(), "test");
    }

    @Test
    public void shouldUpdateTodo() throws Exception {
        // given:
        Todo todo = new Todo("testUpdated");
        todo.setId("0111");

        // when:
        Response resp = todoServiceImpl.updateTodo(todo);

        // then
        verify(crudInterface, times(1)).update(todo);

        // and
        Todo result = (Todo) resp.getEntity();

        // and
        assertEquals(resp.getStatus(), Response.Status.OK.getStatusCode());
        assertEquals(result.getTodo(), "testUpdated");
    }

    @Test
    public void shouldNotUpdateTodoWhenNull() throws Exception {
        // given:
        Todo todo = null;

        // when:
        Response resp = todoServiceImpl.updateTodo(todo);

        // and
        assertEquals(resp.getStatus(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    }

    @Test
    public void shouldNotUpdateTodoWhenIdIsNull() throws Exception {
        // given:
        Todo todo = new Todo("Test");
        todo.setId(null);

        // when:
        Response resp = todoServiceImpl.updateTodo(todo);

        // and
        assertEquals(resp.getStatus(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    }

    @Test
    public void shouldNotUpdateTodoWhenIdIsEmpty() throws Exception {
        // given:
        Todo todo = new Todo("Test");
        todo.setId("");

        // when:
        Response resp = todoServiceImpl.updateTodo(todo);

        // and
        assertEquals(resp.getStatus(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    }

    @Test
    public void shouldDeleteTodo() throws Exception {
        // given:
        String id = "007";

        // when:
        Response resp = todoServiceImpl.deleteTodo(id);

        // then
        verify(crudInterface, times(1)).delete(id);

        // and
        assertEquals(resp.getStatus(), Response.Status.OK.getStatusCode());
    }

    @Test
    public void shouldNotDeleteTodoWhenNull() throws Exception {
        // given:
        String id = null;

        // when:
        Response resp = todoServiceImpl.deleteTodo(id);

        // and
        assertEquals(resp.getStatus(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    }

    @Test
    public void shouldNotDeleteTodoWhenEmpty() throws Exception {
        // given:
        String id = "";

        // when:
        Response resp = todoServiceImpl.deleteTodo(id);

        // and
        assertEquals(resp.getStatus(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    }
}
