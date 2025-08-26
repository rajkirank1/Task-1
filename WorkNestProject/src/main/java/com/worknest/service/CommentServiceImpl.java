package com.worknest.service;

import com.worknest.dao.CommentDAO;
import com.worknest.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public Long add(Comment comment) { return commentDAO.save(comment); }

    @Override
    public List<Comment> forTask(Long taskId) { return commentDAO.findByTaskId(taskId); }

    @Override
    public List<Comment> recent(int limit) { return commentDAO.findRecent(limit); }
}
