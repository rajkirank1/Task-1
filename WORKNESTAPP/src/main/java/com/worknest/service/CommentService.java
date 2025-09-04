package com.worknest.service;

import com.worknest.model.Comment;
import com.worknest.model.Task;
import com.worknest.repository.CommentRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    public List<Comment> findCommentsByTask(Task task) {
        return commentRepository.findByTask(task);
    }

    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }
}
