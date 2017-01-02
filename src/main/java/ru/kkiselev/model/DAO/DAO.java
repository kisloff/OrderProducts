package ru.kkiselev.model.DAO;

import java.util.List;

/**
 * Created by kv on 28.12.16.
 */
public interface DAO<T> {
    List<T> getAll();
    T getById(long id);
    void deleteById(long id);
    void updateById(T instance);
}
