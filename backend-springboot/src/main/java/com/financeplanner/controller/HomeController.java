package com.financeplanner.controller; // <-- Replace with your real package name, like com.example.demo

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // No need .html, Spring will find index.html inside templates/
    }
}
