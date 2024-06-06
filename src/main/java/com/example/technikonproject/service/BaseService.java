package com.example.technikonproject.service;

import com.example.technikonproject.domain.BaseModel;

import java.util.List;

public interface BaseService<T extends BaseModel, K> {

    T create(final T item);

    T read(K id);

    T update(T item);

    void deleteById(K id);

    void delete(T item);

    List<T> findAll();

    boolean exists(T item);

    Long count();

}
