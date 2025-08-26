package com.worknest.service;

import com.worknest.dao.TaskDAO;
import com.worknest.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDAO taskDAO;

    @Override
    public Long create(Task task) { return taskDAO.save(task); }

    @Override
    public Task findById(Long id) { return taskDAO.findById(id); }

    @Override
    public List<Task> tasksForUser(Long userId) { return taskDAO.findByUserId(userId); }

    @Override
    public List<Task> listAll() { return taskDAO.findAll(); }
}
