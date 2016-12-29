package ru.kkiselev.model.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kkiselev.model.POJO.User;
import ru.kkiselev.model.db.DBConnection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kv on 26.12.16.
 */

public class UserDAO implements DAO<User> {

    private static final Logger LOG = LoggerFactory.getLogger(UserDAO.class);

    @Override
    public List<User> getAll() throws SQLException {

        String SELECT_ALL_USERS = "SELECT * FROM USERS ";

        List<User> users = new ArrayList();

        Connection conn = DBConnection.getConnection();
        try (
             Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setAddress(resultSet.getString(3));
                user.setPhone_number(resultSet.getString(4));

                users.add(user);
                //LOG.info(new StringBuilder().append(resultSet.getInt(1)).append(" | ").append(resultSet.getString(2)).toString());
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        LOG.info("All Users retrieved");
        return users;
    }

    @Override
    public User getById(long id) throws SQLException {

        String SELECT_USER = "SELECT * FROM USERS WHERE ID = " + id;

        User user = new User();

        try (Connection conn = DBConnection.getConnection();
             Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_USER);


            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setAddress(resultSet.getString(3));
                user.setPhone_number(resultSet.getString(4));

                //LOG.info(new StringBuilder().append(resultSet.getInt(1)).append(" | ").append(resultSet.getString(2)).toString());
            }
        }

        LOG.info("User" +id + "retrieved");
        return user;
    }

    @Override
    public void deleteById(long id) throws SQLException {
        String DELETE_USER = "DELETE USERS WHERE ID = " + id;

        try (Connection conn = DBConnection.getConnection();
             Statement statement = conn.createStatement()) {
            statement.execute(DELETE_USER);
            LOG.info("User" +id + "deleted");
        }
    }

    @Override
    public void updateById(User instance) throws SQLException {
       String UPDATE_USER = "UPDATE USERS set name = ?, address = ?, phone_number = ? WHERE ID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(UPDATE_USER)) {
            statement.setString(1, instance.getName());
            statement.setString(2, instance.getAddress());
            statement.setString(3, instance.getPhone_number());

            statement.execute();
            LOG.info("User" +instance.getId() + "updated");
        }
    }
}
