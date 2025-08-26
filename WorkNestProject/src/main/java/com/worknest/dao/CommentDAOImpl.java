package com.worknest.dao;

import com.worknest.model.Comment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CommentDAOImpl implements CommentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long save(Comment comment) {
        return (Long) sessionFactory.getCurrentSession().save(comment);
    }

    @Override
    public List<Comment> findByTaskId(Long taskId) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Comment where task.id = :tid order by createdAt desc", Comment.class)
                .setParameter("tid", taskId).list();
    }

    @Override
    public List<Comment> findRecent(int limit) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Comment order by createdAt desc", Comment.class)
                .setMaxResults(limit).list();
    }
}
