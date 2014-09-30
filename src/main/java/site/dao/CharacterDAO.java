package site.dao;

import java.sql.SQLException;

/**
 * Created by maxim on 14.9.30.
 */
public interface CharacterDAO {
    void addCharacter(Character character) throws SQLException;
    void deleteCharacter(Character character) throws SQLException;
    void updateCharacter(Character character) throws SQLException;
}
