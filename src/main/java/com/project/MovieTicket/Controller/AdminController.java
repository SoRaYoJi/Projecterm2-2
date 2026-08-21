package com.project.MovieTicket.Controller;

import com.project.MovieTicket.Repository.BookingRepository;
import com.project.MovieTicket.Repository.MovieRepository;
import com.project.MovieTicket.Repository.PromotionRepository;
import com.project.MovieTicket.Repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired private MovieRepository movieRepository;
    @Autowired private ShowtimeRepository showtimeRepository;
    @Autowired private PromotionRepository promotionRepository;
    @Autowired private BookingRepository bookingRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "admin/login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalMovies", movieRepository.count());
        model.addAttribute("totalBookings", bookingRepository.count());
        model.addAttribute("activePromotions", promotionRepository.findByIsActiveTrueOrderByCreatedAtDesc().size());
        model.addAttribute("totalShowtimes", showtimeRepository.count());
        model.addAttribute("recentBookings", bookingRepository.findAll()
            .stream()
            .sorted((a, b) -> b.getBookingDate().compareTo(a.getBookingDate()))
            .limit(10)
            .toList());
        return "admin/dashboard";
    }
}
