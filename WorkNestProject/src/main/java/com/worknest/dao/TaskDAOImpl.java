package com.worknest.dao;

import com.worknest.model.Task;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TaskDAOImpl implements TaskDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long save(Task task) {
        return (Long) sessionFactory.getCurrentSession().save(task);
    }

    @Override
    public Task findById(Long id) {
        return sessionFactory.getCurrentSession().get(Task.class, id);
    }

    @Override
    public List<Task> findByUserId(Long userId) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Task where assignedUser.id = :uid", Task.class)
                .setParameter("uid", userId).list();
    }

    @Override
    public List<Task> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Task", Task.class).list();
    }
}
