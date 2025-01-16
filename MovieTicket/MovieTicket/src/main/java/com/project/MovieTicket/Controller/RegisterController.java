package com.project.MovieTicket.Controller;

import com.project.MovieTicket.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerForm() {
        return "register"; // ฟอร์มสมัครสมาชิก
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {
        String result = userService.registerUser(username, password);

        // สมัครสำเร็จ -> ไปหน้า Login
        if (result.equals("สมัครสมาชิกสำเร็จ!")) {
            return "redirect:/login"; // ไปหน้าล็อกอิน
        } else {
            // สมัครไม่สำเร็จ -> แสดงข้อความผิดพลาด
            model.addAttribute("error", result);
            return "register"; // กลับไปที่หน้าฟอร์ม
        }
    }
}

