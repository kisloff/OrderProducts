package ru.kkiselev.service;

import ru.kkiselev.model.DAO.ProductDAO;
import ru.kkiselev.model.DAO.UserDAO;
import ru.kkiselev.model.POJO.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by kv on 28.12.16.
 */

//@ProductService
public class ProductService implements Service<Product>{

    ProductDAO pd = new ProductDAO();

    @Override
    public List getAll() throws SQLException {
        return pd.getAll();
    }

    @Override
    public Product getById(long id) throws SQLException {
        return pd.getById(id);
    }

    @Override
    public void deleteById(long id) throws SQLException {
        pd.deleteById(id);
    }

    @Override
    public void updateById(Product instance) throws SQLException {
        pd.updateById(instance);
    }
}
