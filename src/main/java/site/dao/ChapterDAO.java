package site.dao;

import site.entity.Chapter;

import java.sql.SQLException;

/**
 * Created by maxim on 14.9.30.
 */
public interface ChapterDAO {
    Chapter findChapter(String title) throws SQLException;
    void addChapter(Chapter chapter) throws SQLException;
    void deleteChapter(Chapter chapter) throws SQLException;
    void updateChapter(Chapter chapter) throws SQLException;
}
