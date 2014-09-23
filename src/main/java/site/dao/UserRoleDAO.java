package site.dao;

import site.entity.UserRole;

import java.sql.SQLException;

/**
 * Created by maxim on 14.9.21.
 */
public interface UserRoleDAO {
    void addRole(UserRole role) throws SQLException;
    UserRole getRole(String role) throws  SQLException;
    void deleteRole(UserRole role) throws SQLException;
}