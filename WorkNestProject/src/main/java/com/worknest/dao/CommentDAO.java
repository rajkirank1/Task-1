package com.worknest.dao;

import com.worknest.model.Comment;
import java.util.List;

public interface CommentDAO {
    Long save(Comment comment);
    List<Comment> findByTaskId(Long taskId);
    List<Comment> findRecent(int limit);
}
