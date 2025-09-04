package com.worknest.repository;

import com.worknest.model.Comment;
import com.worknest.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByTask(Task task);
}
