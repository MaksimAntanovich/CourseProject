package site.dao;

import site.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxim on 14.9.21.
 */
public interface UserDAO {
    void addUser(User user) throws SQLException;
    User getUser(String login) throws  SQLException;
    void deleteUser(User user) throws SQLException;
    void updateUser(User user) throws SQLException;
    List<User> getAllUsers() throws SQLException;
}
