package com.peaksoft.dao;

import com.peaksoft.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        return sessionFactory
                .openSession()
                .createQuery("from User")
                .getResultList();
    }

    @Override
    public void addUser(User user) {
        sessionFactory.openSession().save(user);
    }


    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);

    }

    @Override
    public void deleteUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.contains(user) ? user : session.merge(user));
    }

    @Override
    public User get(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public User findByUserName(String username) {
        List<User> users = getAllUsers();
        return users.stream().filter(x -> x.getUsername().equals(username)).findAny().orElse(new User());
    }
}
