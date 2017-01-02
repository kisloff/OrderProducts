package ru.kkiselev.service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by kv on 28.12.16.
 */
public interface Service<T> {
    List<T> getAll();
    T getById(long id);
    void deleteById(long id);
    void updateById(T instance);
}
