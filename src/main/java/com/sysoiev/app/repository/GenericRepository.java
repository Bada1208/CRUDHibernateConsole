package com.sysoiev.app.repository;

import java.util.List;

public interface GenericRepository<T, ID> {
    void save(T data);

    List<T> getAll();

    T getById(ID id);

    void update(T data);

    void deleteById(ID id);
}
