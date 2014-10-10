package site.daoimpl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import site.dao.ChapterDAO;
import site.entity.Chapter;

import javax.swing.*;

/**
 * Created by maxim on 14.9.30.
 */
@Transactional
@Repository("ChapterDAO")
public class ChapterDAOImpl implements ChapterDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(ChapterDAOImpl.class);

    @Override
    public void addChapter(Chapter chapter){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(chapter);
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
    public void deleteChapter(Chapter chapter){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(chapter);
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
    public void updateChapter(Chapter chapter){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(chapter);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.trace(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
