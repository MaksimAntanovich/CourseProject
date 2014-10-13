package site.daoimpl;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import site.dao.AnnotationDAO;
import site.dao.StoryDAO;
import site.entity.Annotation;
import site.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by maxim on 14.10.13.
 */
@Transactional
@Repository("AnnotationDAO")
public class AnnotationDAOImpl implements AnnotationDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private StoryDAO storyDAO;


    private static final Logger logger = Logger.getLogger(ChapterDAOImpl.class);

    @Override
    public void addAnnotation(Annotation annotation){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(annotation);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.trace(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateAnnotation(Annotation annotation){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.merge(annotation);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.trace(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Annotation getAnnotation(String title, User user) {
        Session session = null;
        Annotation annotation = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            ArrayList<Annotation> results = (ArrayList<Annotation>) session.createCriteria(Annotation.class).add( Restrictions.like("story", storyDAO.getStory(title))).add( Restrictions.like("user", user)).list();
            annotation = results.get(results.size() - 1);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.trace(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return annotation;
    }
}
