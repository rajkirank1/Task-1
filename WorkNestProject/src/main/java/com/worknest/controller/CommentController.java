package com.worknest.controller;

import com.worknest.model.Comment;
import com.worknest.model.Task;
import com.worknest.model.User;
import com.worknest.service.CommentService;
import com.worknest.service.TaskService;
import com.worknest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired private CommentService commentService;
    @Autowired private TaskService taskService;
    @Autowired private UserService userService;

    @PostMapping("/add")
    public String add(@RequestParam Long taskId, @RequestParam String text, HttpSession session){
        User u = (User) session.getAttribute("user");
        if(u == null) return "redirect:/auth/login";
        Task t = taskService.findById(taskId);
        Comment c = new Comment();
        c.setText(text);
        c.setCreatedAt(LocalDateTime.now());
        c.setTask(t);
        c.setUser(u);
        commentService.add(c);
        return "redirect:/task/details?taskId=" + taskId;
    }
}
