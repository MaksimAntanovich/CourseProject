package site.daoimpl;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import site.dao.StoryDAO;
import site.entity.Chapter;
import site.entity.Story;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by maxim on 14.10.2.
 */
@Transactional
@Repository("StoryDAO")
public class StoryDAOImpl implements StoryDAO{
    @Autowired
    SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(StoryDAOImpl.class);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoryDAOImpl storyDAO = (StoryDAOImpl) o;

        if (sessionFactory != null ? !sessionFactory.equals(storyDAO.sessionFactory) : storyDAO.sessionFactory != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return sessionFactory != null ? sessionFactory.hashCode() : 0;
    }

    @Override
    public void addStory(Story story){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(story);
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
    public void updateStory(Story story){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(story);
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
    public Story getStory(String title){
        Session session = null;
        Story story = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            story = (Story) session.createCriteria(Story.class).add( Restrictions.like("title", title)).list().get(0);
            Hibernate.initialize(story.getChapters());
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.trace(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return story;
    }


    @Override
    public ArrayList<Story> getAllStories(){
        Session session = null;
        ArrayList<Story> stories = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            stories = (ArrayList<Story>) session.createCriteria(Story.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.trace(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return stories;
    }

    @Override
    public void deleteStory(Story story){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(story);
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
