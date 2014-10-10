package site.daoimpl;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import site.dao.UserRoleDAO;
import site.entity.UserRole;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.*;

/**
 * Created by maxim on 14.9.21.
 */
@Transactional
@Repository("UserRoleDAO")
public class UserRoleDAOImpl implements UserRoleDAO{
    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(UserRoleDAOImpl.class);

    @Override
    public void addRole(UserRole role){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(role);
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
    public UserRole getRole(String role){
        Session session = null;
        UserRole userRole = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            userRole = (UserRole) session.load(UserRole.class, role);
            Hibernate.initialize(userRole);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.trace(e);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
        return userRole;
    }

    @Override
    public void deleteRole(UserRole role){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(role);
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
