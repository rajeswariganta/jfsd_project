package com.klu.pro.controller;

import com.klu.pro.entity.User;
import com.klu.pro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Show the registration form
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());  // Empty user object for form binding
        return "register";  // View name for the registration page
    }

    // Handle the registration form submission
    @PostMapping("/register") 
    public String registerUser(User user, Model model) {
        try {
            // Check if the email already exists
            if (userService.getUserByEmail(user.getEmail()) != null) {
                model.addAttribute("error", "This email is already registered. Please try another one.");
                return "register.html";  // Return to the register page with the error message
            }

            // Save the user if validation passes
            userService.saveUser(user);
            model.addAttribute("success", "Registration successful! Please log in.");
            return "redirect:/login.html";  // Redirect to the login page after successful registration
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while processing your registration. Please try again.");
            return "register.html";  // Return to the register page if an error occurs
        }
    }
}
