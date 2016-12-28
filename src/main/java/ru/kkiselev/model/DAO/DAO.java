package ru.kkiselev.model.DAO;

import java.util.List;

/**
 * Created by kv on 28.12.16.
 */
public interface DAOI<T> {
    public List<T> getAllProducts();
    public T getById();
}
