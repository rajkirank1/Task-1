package com.worknest.controller;

import com.worknest.model.Comment;
import com.worknest.service.CommentService;
import com.worknest.service.TaskService;
import com.worknest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired private UserService userService;
    @Autowired private TaskService taskService;
    @Autowired private CommentService commentService;

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session){
        // Basic counts - real logic would analyze task statuses
        model.addAttribute("pending", 0);
        model.addAttribute("inProgress", 0);
        model.addAttribute("completed", 0);
        model.addAttribute("delayed", 0);

        List<Comment> recent = commentService.recent(10);
        model.addAttribute("comments", recent);
        return "adminDashboard";
    }
}
