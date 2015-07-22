package com.springrest.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springrest.persistence.CrudInterface;
import com.springrest.persistence.CrudInterfaceImpl;
import com.springrest.service.TodoService;
import com.springrest.service.TodoServiceImpl;

@Configuration
public class BeanConfig {

    @Bean
    public CrudInterface<?> crudInterface() {
        return new CrudInterfaceImpl();
    }

    @Bean
    public TodoService todoService() {
        return new TodoServiceImpl();
    }
}
