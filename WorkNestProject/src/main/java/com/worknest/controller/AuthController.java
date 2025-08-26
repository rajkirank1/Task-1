package com.worknest.controller;

import com.worknest.model.User;
import com.worknest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginForm(){ return "login"; }

    @GetMapping("/register")
    public String registerForm(){ return "register"; }

    @PostMapping("/register")
    public String register(User user, Model model){
        userService.register(user);
        return "redirect:/auth/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model){
        User u = userService.findByEmail(email);
        if(u != null && u.getPassword().equals(password)){
            session.setAttribute("user", u);
            if("ADMIN".equalsIgnoreCase(u.getRole())) return "redirect:/admin/dashboard";
            else return "redirect:/user/dashboard";
        }
        model.addAttribute("error","Invalid credentials");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
