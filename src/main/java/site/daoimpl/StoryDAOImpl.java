package site.daoimpl;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import site.dao.StoryDAO;
import site.entity.Story;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by maxim on 14.10.2.
 */
public class StoryDAOImpl implements StoryDAO{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addStory(Story story){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(story);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "insert exception", JOptionPane.OK_OPTION);
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
            story = (Story) session.load(Story.class, title);
            Hibernate.initialize(story.getChapters());
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "insert exception", JOptionPane.OK_OPTION);
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
        ArrayList<Story> categories = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            categories = (ArrayList<Story>) session.createCriteria(Story.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "insert exception", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return categories;
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
            JOptionPane.showMessageDialog(null, e.getMessage(), "insert exception", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
