package com.worknest.controller;

import com.worknest.model.Task;
import com.worknest.model.User;
import com.worknest.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired private TaskService taskService;

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model){
        User u = (User) session.getAttribute("user");
        if(u == null) return "redirect:/auth/login";
        List<Task> tasks = taskService.tasksForUser(u.getId());
        model.addAttribute("tasks", tasks);
        return "userDashboard";
    }
}
