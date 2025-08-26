package com.worknest.service;

import com.worknest.model.Task;
import java.util.List;

public interface TaskService {
    Long create(Task task);
    Task findById(Long id);
    List<Task> tasksForUser(Long userId);
    List<Task> listAll();
}
