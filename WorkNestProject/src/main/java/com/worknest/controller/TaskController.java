package com.worknest.controller;

import com.worknest.model.Task;
import com.worknest.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired private TaskService taskService;

    @PostMapping("/updateStatus")
    public String updateStatus(@RequestParam Long taskId, @RequestParam String status){
        Task t = taskService.findById(taskId);
        if(t != null){
            t.setStatus(status);
            taskService.create(t); // save/update (simplified)
        }
        return "redirect:/user/dashboard";
    }

    @GetMapping("/details")
    public String details(@RequestParam Long taskId, javax.servlet.http.HttpServletRequest req){
        Task t = taskService.findById(taskId);
        req.setAttribute("task", t);
        return "taskDetails";
    }
}
