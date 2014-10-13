package site.dao;

import org.hibernate.Hibernate;
import site.entity.Chapter;
import site.entity.Story;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by maxim on 14.10.2.
 */
public interface StoryDAO {
    void addStory(Story story) throws SQLException;
    void updateStory(Story story) throws SQLException;
    Story getStory(String title) throws  SQLException;
    ArrayList<Story> getAllStories() throws SQLException;
    void deleteStory(Story story) throws SQLException;
}
