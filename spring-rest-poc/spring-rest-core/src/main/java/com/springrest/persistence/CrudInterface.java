package com.springrest.persistence;

import java.util.List;

public interface CrudInterface<T> {

    void create(T t) throws Exception;

    List<T> retrieve() throws Exception;

    void update(T t) throws Exception;

    void delete(String id) throws Exception;


}
