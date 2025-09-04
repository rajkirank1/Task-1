package com.worknest.controller;

import com.worknest.model.Role;
import com.worknest.model.User;
import com.worknest.service.RoleService;
import com.worknest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, @RequestParam("role") String roleName, Model model) {
        if (userService.existsByUsername(user.getUsername())) {
            model.addAttribute("error", "Username already exists");
            return "register";
        }
        if (userService.existsByEmail(user.getEmail())) {
            model.addAttribute("error", "Email already exists");
            return "register";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleService.findByName(roleName).orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRoles(Collections.singleton(role));
        userService.saveUser(user);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}
