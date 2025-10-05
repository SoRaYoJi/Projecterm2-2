package com.project.MovieTicket.Controller;

import ch.qos.logback.core.model.Model;
import com.project.MovieTicket.Entity.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
