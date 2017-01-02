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

    private static String SELECT_ALL_USERS = "SELECT * FROM USERS ";

    private static String UPDATE_USER = "UPDATE USERS set name = ?, address = ?, phone_number = ? WHERE ID = ?";

    @Override
    public List<User> getAll(){

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
            }
        } catch (SQLException e){
            LOG.error(e.getMessage());
        }

        LOG.info("All Users retrieved");
        return users;
    }

    @Override
    public User getById(long id){

        String SELECT_USER = "SELECT * FROM USERS WHERE ID = " + id;

        User user = new User();
        Connection conn = DBConnection.getConnection();
        try (
             Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_USER);

            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setAddress(resultSet.getString(3));
                user.setPhone_number(resultSet.getString(4));

            }
        } catch (SQLException e){
            LOG.error(e.getMessage());
        }

        LOG.info("User" +id + "retrieved");
        return user;
    }

    @Override
    public void deleteById(long id){
        String DELETE_USER = "DELETE USERS WHERE ID = " + id;
        Connection conn = DBConnection.getConnection();
        try (
             Statement statement = conn.createStatement()) {
            statement.execute(DELETE_USER);
            LOG.info("User" +id + "deleted");
        } catch (SQLException e){
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void updateById(User instance){

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(UPDATE_USER)) {
            statement.setString(1, instance.getName());
            statement.setString(2, instance.getAddress());
            statement.setString(3, instance.getPhone_number());
            statement.setInt(4, instance.getId());

            statement.execute();
            LOG.info("User" +instance.getId() + "updated");
        } catch (SQLException e){
            LOG.error(e.getMessage());
        }
    }
}
