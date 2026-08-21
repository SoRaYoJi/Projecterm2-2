package com.project.MovieTicket.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Register is no longer needed for general users.
// Public users book as guests. Only admin accounts exist.
@Controller
public class RegisterController {

    @GetMapping("/register")
    public String register() {
        return "redirect:/home";
    }
}
