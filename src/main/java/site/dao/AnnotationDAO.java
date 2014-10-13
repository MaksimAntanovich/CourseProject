package site.dao;

import site.entity.Annotation;
import site.entity.User;

import java.sql.SQLException;

/**
 * Created by maxim on 14.10.13.
 */
public interface AnnotationDAO {
    void addAnnotation(Annotation annotation) throws SQLException;
    void updateAnnotation(Annotation annotation) throws SQLException;
    Annotation getAnnotation(String title,User user) throws  SQLException;
}
