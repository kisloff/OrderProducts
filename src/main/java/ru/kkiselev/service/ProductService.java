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
    public List getAll() {
        return pd.getAll();
    }

    @Override
    public Product getById(long id) {
        return pd.getById(id);
    }

    @Override
    public void deleteById(long id) {
        pd.deleteById(id);
    }

    @Override
    public void updateById(Product instance){
        pd.updateById(instance);
    }
}
