package ru.kkiselev.model.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kkiselev.model.POJO.User;
import ru.kkiselev.model.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kv on 26.12.16.
 */

public class User_DAO {

    String SELECT_ALL_USERS = "SELECT * FROM USERS";

    private static final Logger LOG = LoggerFactory.getLogger(User_DAO.class);

    public List<User> getAllUsers() throws SQLException{
        User user = new User();
        List<User> users = new ArrayList();

        try (Connection conn = DriverManager.getConnection(DBConnection.connection);
             Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS);
            LOG.info("Users TABLE");

            while (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setAddress(resultSet.getString(3));
                user.setPhone_number(resultSet.getString(4));

                users.add(user);
                //LOG.info(new StringBuilder().append(resultSet.getInt(1)).append(" | ").append(resultSet.getString(2)).toString());
            }
        }

        return users;
    }
}
