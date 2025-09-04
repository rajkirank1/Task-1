package com.worknest.service;

import com.worknest.model.Task;
import com.worknest.model.User;
import com.worknest.repository.TaskRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> findTasksByUser(User user) {
        return taskRepository.findByAssignedUsers(user);
    }

    public List<Task> findTasksByStatus(Task.Status status) {
        return taskRepository.findByStatus(status);
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }
}
