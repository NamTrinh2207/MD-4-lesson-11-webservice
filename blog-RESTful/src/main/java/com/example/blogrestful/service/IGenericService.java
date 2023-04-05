package com.example.blogrestful.service;

import java.util.Optional;

public interface IGenericService<T> {
    Iterable<T> fidAll();

    Optional<T> findById(Long id);

    T save(T t);

    void delete(Long id);
}
