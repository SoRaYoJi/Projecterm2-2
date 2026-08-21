package com.project.MovieTicket.Controller;

import com.project.MovieTicket.Entity.Booking;
import com.project.MovieTicket.Repository.BookingRepository;
import com.project.MovieTicket.Repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class AllController {

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @GetMapping("/promotion")
    public String promotionPage(Model model) {
        model.addAttribute("promotions", promotionRepository.findByIsActiveTrueOrderByCreatedAtDesc());
        return "promotion";
    }

    @GetMapping("/cinema")
    public String cinemaPage(@RequestParam(value = "movieId", defaultValue = "0") int movieId,
                             @RequestParam(value = "movie", defaultValue = "") String movieName,
                             Model model) {
        model.addAttribute("movieId", movieId);
        model.addAttribute("movieName", movieName);
        return "cinema";
    }

    @GetMapping("/seat")
    public String seatPage(@RequestParam(value = "showtimeId", required = false) Long showtimeId,
                           @RequestParam(value = "movie", defaultValue = "") String movie,
                           @RequestParam(value = "cinema", defaultValue = "") String cinema,
                           @RequestParam(value = "time", defaultValue = "") String time,
                           @RequestParam(value = "date", defaultValue = "") String date,
                           @RequestParam(value = "hall", defaultValue = "") String hall,
                           @RequestParam(value = "price", defaultValue = "250") double price,
                           Model model) {
        model.addAttribute("showtimeId", showtimeId);
        model.addAttribute("movieName", movie);
        model.addAttribute("cinema", cinema);
        model.addAttribute("time", time);
        model.addAttribute("date", date);
        model.addAttribute("hall", hall);
        model.addAttribute("price", price);
        return "seat";
    }

    @GetMapping("/buyticket")
    public String buyticketPage(@RequestParam(value = "movie", defaultValue = "") String movie,
                                @RequestParam(value = "cinema", defaultValue = "") String cinema,
                                @RequestParam(value = "time", defaultValue = "") String time,
                                @RequestParam(value = "date", defaultValue = "") String date,
                                @RequestParam(value = "hall", defaultValue = "") String hall,
                                @RequestParam(value = "seats", defaultValue = "2") int seats,
                                @RequestParam(value = "seatNumbers", defaultValue = "") String seatNumbers,
                                @RequestParam(value = "price", defaultValue = "250") double price,
                                Model model) {
        model.addAttribute("movieName", movie);
        model.addAttribute("cinema", cinema);
        model.addAttribute("time", time);
        model.addAttribute("date", date);
        model.addAttribute("hall", hall);
        model.addAttribute("seats", seats);
        model.addAttribute("seatNumbers", seatNumbers);
        model.addAttribute("price", price);
        model.addAttribute("totalPrice", seats * price);
        return "buyticket";
    }

    @GetMapping("/profile")
    public String profileRedirect() {
        return "redirect:/my-tickets";
    }

    @GetMapping("/my-tickets")
    public String myTickets(@RequestParam(value = "query", required = false) String query, Model model) {
        List<Booking> bookings = Collections.emptyList();
        if (query != null && !query.isBlank()) {
            query = query.trim();
            // Check if query matches booking code
            Optional<Booking> byCode = bookingRepository.findByBookingCode(query);
            if (byCode.isPresent()) {
                bookings = List.of(byCode.get());
            } else {
                // Search by email
                bookings = bookingRepository.findByCustomerEmailOrderByBookingDateDesc(query);
            }
        }
        model.addAttribute("bookings", bookings);
        model.addAttribute("query", query);
        return "profile";
    }
}
