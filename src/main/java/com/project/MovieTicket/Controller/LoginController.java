package com.project.MovieTicket.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    // Redirect old /login to admin login
    @GetMapping("/login")
    public String login() {
        return "redirect:/admin/login";
    }
}
