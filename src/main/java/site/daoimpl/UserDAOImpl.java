package site.daoimpl;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import site.dao.UserDAO;
import site.entity.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

/**
 * Created by maxim on 14.9.21.
 */
@Transactional
@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

    @Override
    public void addUser(User user){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(user);
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
    public User getUser(String login){
        Session session = null;
        User user = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            user = (User) session.createCriteria(User.class).add( Restrictions.like("login",login)).list().get(0);
            Hibernate.initialize(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.trace(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    @Override
    public void deleteUser(User user){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(user);
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
    public void updateUser(User user){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(user);
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
