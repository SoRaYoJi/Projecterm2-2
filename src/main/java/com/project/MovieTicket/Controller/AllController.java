package com.project.MovieTicket.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AllController {

    @RequestMapping("/home")
    public String showHomePage() {
        return "home"; // หน้า home.jsp
    }

    @RequestMapping("/movies")
    public String showMoviesPage() {
        return "movies";  // หน้า movies.jsp
    }

    @GetMapping("/cinema")
    public String cinemaPage(Model model) {
        model.addAttribute("movieName", "GHOSTBUSTERS"); // ตัวอย่างค่าตัวแปร
        return "cinema"; // ชื่อไฟล์ cinema.jsp
    }

    @RequestMapping("/promotion")
    public String showPromotionPage() {
        return "promotion";  // หน้า promotion.jsp
    }

    @RequestMapping("/seat")
    public String showSeatPage() {
        return "seat";  // หน้า seat.jsp
    }

    @RequestMapping("/buyticket")
    public String showBuyticketPage() {
        return "buyticket";  // หน้า seat.jsp
    }

    @GetMapping("/seat")
    public String seatPage(Model model) {
        model.addAttribute("movieName", "GHOSTBUSTERS"); // ตัวอย่างค่าตัวแปร
        return "seat"; // ชื่อไฟล์ cinema.jsp
    }

    @RequestMapping("/profile")
    public String showProfilePage() {
        return "profile";  // หน้า promotion.jsp
    }

    @GetMapping("/buyticket")
    public String buyticketPage(Model model) {
        model.addAttribute("movieName", "GHOSTBUSTERS"); // ตัวอย่างค่าตัวแปร
        return "buyticket"; //
    }


    @GetMapping("/ticket")
    public String ticketPage(Model model) {
        model.addAttribute("movieName", "GHOSTBUSTERS"); // ตัวอย่างค่าตัวแปร
        return "ticket"; // ชื่อไฟล์ cinema.jsp
    }

    @GetMapping("/receipt")
    public String receiptPage(Model model) {
        model.addAttribute("movieName", "GHOSTBUSTERS"); // ตัวอย่างค่าตัวแปร
        return "receipt"; // ชื่อไฟล์ cinema.jsp
    }
}

