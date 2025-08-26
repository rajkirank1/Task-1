package com.worknest.dao;

import com.worknest.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long save(User user) {
        return (Long) sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User findByEmail(String email) {
        return sessionFactory.getCurrentSession()
                .createQuery("from User where email = :e", User.class)
                .setParameter("e", email).uniqueResult();
    }

    @Override
    public User findById(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from User", User.class).list();
    }
}
