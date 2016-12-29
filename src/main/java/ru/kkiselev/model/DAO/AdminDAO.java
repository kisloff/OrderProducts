package ru.kkiselev.model.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kkiselev.model.db.DBConnection;

import java.sql.*;

/**
 * Created by kv on 27.12.16.
 */
public class AdminDAO {

    private static final Logger LOG = LoggerFactory.getLogger(Basket_itemDAO.class);

    public void register(String login, String password){
        String REGISTER_ADMIN = "INSERT INTO ADMINS values login = ?, password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(REGISTER_ADMIN)) {
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            resultSet.getInt(1);

            LOG.info("Admin" + login + "added");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean isAdmin(String login, String password){
        String IS_ADMIN_QUERY = "SELECT COUNT (1) FROM ADMINS where LOGIN = ? and Password = ?";
        boolean isAdmin = false;

        int count = 0;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(IS_ADMIN_QUERY)) {
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            count = resultSet.getInt(1);

            LOG.info("User" + login + "checked");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(count > 0){
            isAdmin = true;
        }

        return isAdmin;
    }
}
