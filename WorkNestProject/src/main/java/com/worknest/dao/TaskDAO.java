package com.worknest.dao;

import com.worknest.model.Task;
import java.util.List;

public interface TaskDAO {
    Long save(Task task);
    Task findById(Long id);
    List<Task> findByUserId(Long userId);
    List<Task> findAll();
}
