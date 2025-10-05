package com.project.MovieTicket.Controller;

import com.project.MovieTicket.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TicketController {

    @PostMapping("/submit-booking")
    public String submitBooking(
            @RequestParam("movie") String movie,
            @RequestParam("cinema") String cinema,
            @RequestParam("time") String time,
            @RequestParam("seats") int seats,
            Model model
    ) {
        // ส่งข้อมูลไปแสดงใน buyticket.html
        model.addAttribute("movie", movie);
        model.addAttribute("cinema", cinema);
        model.addAttribute("time", time);
        model.addAttribute("seats", seats);

        // เปลี่ยนเส้นทางไปหน้า buyticket.html
        return "buyticket";
    }
}
