package ru.kkiselev.model.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kkiselev.model.POJO.Product;
import ru.kkiselev.model.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kv on 28.12.16.
 */
public class ProductDAO implements DAO<Product> {

    private static final Logger LOG = LoggerFactory.getLogger(UserDAO.class);
    private final static String SELECT_ALL_PRODUCTS = "SELECT * FROM PRODUCTS";
    private final static String UPDATE_PRODUCT = "UPDATE PRODUCTS set name = ?, description = ?, price = ? WHERE ID = ?";

    @Override
    public List<Product> getAll() {

        List<Product> products = new ArrayList<>();

        Connection conn = DBConnection.getConnection();

        try (Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_PRODUCTS)){

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setDescription(resultSet.getString(3));
                product.setPrice(resultSet.getInt(4));

                products.add(product);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }

        LOG.info("All Products retrieved");
        return products;
    }

    @Override
    public Product getById(long id) {
        String SELECT_USER = "SELECT * FROM PRODUCTS WHERE ID = " + id;

        Product product = new Product();

        try (Connection conn = DBConnection.getConnection();
             Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_USER);


            if (resultSet.next()) {
                product.setId(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setDescription(resultSet.getString(3));
                product.setPrice(resultSet.getInt(4));
            }
        } catch (SQLException e){
            LOG.error(e.getMessage());
        }

        LOG.info("User" + id + "retrieved");
        return product;
    }

    @Override
    public void deleteById(long id) {
        String DELETE_USER = "DELETE PRODUCTS WHERE ID = " + id;

        try (Connection conn = DBConnection.getConnection();
             Statement statement = conn.createStatement()) {
            statement.execute(DELETE_USER);
            LOG.info("Product" + id + "deleted");
        } catch (SQLException e){
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void updateById(Product instance) {

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(UPDATE_PRODUCT)) {
            statement.setString(1, instance.getName());
            statement.setString(2, instance.getDescription());
            statement.setInt(3, instance.getPrice());
            statement.setInt(4, instance.getId());
            statement.execute();
            LOG.info("User" + instance.getId() + "updated");
        } catch (SQLException e){
            LOG.error(e.getMessage());
        }
    }
}
