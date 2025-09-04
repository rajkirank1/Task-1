package com.worknest.repository;

import com.worknest.model.Task;
import com.worknest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAssignedUsers(User user);
    List<Task> findByStatus(Task.Status status);
}
