package ru.kkiselev.service;

import ru.kkiselev.model.DAO.UserDAO;
import ru.kkiselev.model.POJO.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by kv on 28.12.16.
 */
public class UserService implements Service<User>{
    UserDAO ud = new UserDAO();

    @Override
    public List<User> getAll() throws SQLException {
        return ud.getAll();
    }

    @Override
    public User getById(long id) throws SQLException {
        return ud.getById(id);
    }

    @Override
    public void deleteById(long id) throws SQLException {
        ud.deleteById(id);
    }

    @Override
    public void updateById(User instance) throws SQLException {
        ud.updateById(instance);
    }
}
