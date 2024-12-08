package com.klu.pro.controller;

import com.klu.pro.entity.User;
import com.klu.pro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // Display login page
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, Model model) {
        User user = userService.validateUser(email, password);

        if (user != null) {
            // Redirect based on role
            if ("student".equalsIgnoreCase(user.getRole())) {
                return "redirect:/student-dashboard.html";  // Redirect to student dashboard
            } else if ("teacher".equalsIgnoreCase(user.getRole())) {
                return "redirect:/teacher-dashboard.html";  // Redirect to teacher dashboard
            }
        }

        model.addAttribute("error", "Invalid email or password");
        return "login.html";  // Stay on login page if invalid credentials
    }
}
