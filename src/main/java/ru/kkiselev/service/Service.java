package ru.kkiselev.service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by kv on 28.12.16.
 */
public interface Service<T> {
    List<T> getAll() throws SQLException;
    T getById(long id) throws SQLException;
    void deleteById(long id) throws SQLException;
    void updateById(T instance) throws SQLException;
}
