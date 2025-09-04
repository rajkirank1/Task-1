package com.worknest.controller;

import com.worknest.model.Comment;
import com.worknest.model.Task;
import com.worknest.model.User;
import com.worknest.service.CommentService;
import com.worknest.service.TaskService;
import com.worknest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/dashboard")
    public String userDashboard(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.findByUsername(userDetails.getUsername()).orElseThrow();
        List<Task> tasks = taskService.findTasksByUser(user);
        model.addAttribute("tasks", tasks);
        return "user/dashboard";
    }

    @PostMapping("/tasks/{taskId}/status")
    public String updateTaskStatus(@PathVariable Long taskId, @RequestParam Task.Status status) {
        Task task = taskService.findById(taskId).orElseThrow();
        task.setStatus(status);
        taskService.saveTask(task);
        return "redirect:/user/dashboard";
    }

    @PostMapping("/tasks/{taskId}/comments")
    public String addComment(@PathVariable Long taskId, @RequestParam String content, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByUsername(userDetails.getUsername()).orElseThrow();
        Task task = taskService.findById(taskId).orElseThrow();
        Comment comment = new Comment();
        comment.setTask(task);
        comment.setUser(user);
        comment.setContent(content);
        comment.setCreatedAt(LocalDateTime.now());
        commentService.saveComment(comment);
        return "redirect:/user/dashboard";
    }
}
