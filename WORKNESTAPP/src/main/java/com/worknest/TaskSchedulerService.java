package com.worknest;

import com.worknest.model.Task;
import com.worknest.service.TaskService;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskSchedulerService {

    private final TaskService taskService;

    public TaskSchedulerService(TaskService taskService) {
        this.taskService = taskService;
    }

    // Runs every Monday at 8 AM
    @Scheduled(cron = "0 0 8 * * MON")
    public void weeklyTaskUpdate() {
        List<Task> allTasks = taskService.findAllTasks();
        LocalDate now = LocalDate.now();

        for (Task task : allTasks) {
            if (task.getStatus() != Task.Status.COMPLETED) {
                if (now.isAfter(task.getDueDate())) {
                    task.setStatus(Task.Status.DELAYED);
                } else if (now.isEqual(task.getStartDate()) || now.isAfter(task.getStartDate())) {
                    task.setStatus(Task.Status.IN_PROGRESS);
                } else {
                    task.setStatus(Task.Status.PENDING);
                }
                taskService.saveTask(task);
            }
        }

        // Additional logic to generate assessment reports or notify admins/users can be added here
    }
}
