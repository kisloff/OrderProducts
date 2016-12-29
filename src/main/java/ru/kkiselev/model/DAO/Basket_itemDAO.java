package ru.kkiselev.model.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by kv on 28.12.16.
 */
public class Basket_itemDAO implements DAO<Basket_itemDAO> {

    private static final Logger LOG = LoggerFactory.getLogger(Basket_itemDAO.class);

    @Override
    public List<Basket_itemDAO> getAll() throws SQLException {
        return null;
    }

    @Override
    public Basket_itemDAO getById(long id) throws SQLException {
        return null;
    }

    @Override
    public void deleteById(long id) throws SQLException {

    }

    @Override
    public void updateById(Basket_itemDAO instance) throws SQLException {

    }
}
