package com.worknest.controller;

import com.worknest.model.Task;
import com.worknest.model.User;
import com.worknest.service.TaskService;
import com.worknest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("tasks", taskService.findAllTasks());
        return "admin/dashboard";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "admin/users";
    }

    @GetMapping("/tasks/new")
    public String showTaskForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("users", userService.findAllUsers());
        return "admin/task-form";
    }

    @PostMapping("/tasks")
    public String createTask(@ModelAttribute Task task, @RequestParam List<Long> assignedUserIds) {
        task.setStatus(Task.Status.PENDING);
        taskService.saveTask(task);
        List<User> assignedUsers = userService.findAllUsers().stream()
                .filter(u -> assignedUserIds.contains(u.getId()))
                .toList();
        task.setAssignedUsers(Set.copyOf(assignedUsers));
        taskService.saveTask(task);
        return "redirect:/admin/dashboard";
    }
}
