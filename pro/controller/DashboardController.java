package com.klu.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("/student-dashboard")
    public String studentDashboard() {
        return "student-dashboard";  // No changes needed here
    }

    @GetMapping("/teacher-dashboard")
    public String teacherDashboard() {
        return "teacher-dashboard";  // No changes needed here
    }
}
