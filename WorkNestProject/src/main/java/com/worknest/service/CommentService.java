package com.worknest.service;

import com.worknest.model.Comment;
import java.util.List;

public interface CommentService {
    Long add(Comment comment);
    List<Comment> forTask(Long taskId);
    List<Comment> recent(int limit);
}
