package com.example.hqlandcriteriagreenatom.dao.impl;

import com.example.hqlandcriteriagreenatom.dao.UserDAO;
import com.example.hqlandcriteriagreenatom.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImplHQL implements UserDAO {
    private SessionFactory sessionFactory;

    public UserDAOImplHQL(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM User WHERE id = :id";
            Query<User> query = session.createQuery(hql);
            query.setParameter("id", id);
            return query.uniqueResult();
        }
    }

    @Override
    public List<User> findAll() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM User";
            Query<User> query = session.createQuery(hql);
            return query.getResultList();
        }
    }

    @Override
    public void save(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        }
    }

    @Override
    public void update(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(user);
            tx.commit();
        }
    }

    @Override
    public void delete(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(user);
            tx.commit();
        }
    }
}