package com.project.MovieTicket.Controller;

import com.project.MovieTicket.Entity.Movie;
import com.project.MovieTicket.Entity.Showtime;
import com.project.MovieTicket.Repository.MovieRepository;
import com.project.MovieTicket.Repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/showtimes")
public class AdminShowtimeController {

    @Autowired private ShowtimeRepository showtimeRepository;
    @Autowired private MovieRepository movieRepository;

    @GetMapping
    public String listShowtimes(Model model) {
        model.addAttribute("showtimes", showtimeRepository.findAll());
        return "admin/showtimes";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("showtime", new Showtime());
        model.addAttribute("movies", movieRepository.findAll());
        model.addAttribute("editMode", false);
        return "admin/showtime-form";
    }

    @PostMapping("/add")
    public String addShowtime(@ModelAttribute Showtime showtime,
                              @RequestParam int movieId, RedirectAttributes ra) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        showtime.setMovie(movie);
        showtime.setAvailableSeats(showtime.getTotalSeats());
        showtimeRepository.save(showtime);
        ra.addFlashAttribute("success", "เพิ่มรอบฉายสำเร็จ!");
        return "redirect:/admin/showtimes";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Showtime showtime = showtimeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Showtime not found"));
        model.addAttribute("showtime", showtime);
        model.addAttribute("movies", movieRepository.findAll());
        model.addAttribute("editMode", true);
        return "admin/showtime-form";
    }

    @PostMapping("/edit/{id}")
    public String editShowtime(@PathVariable Long id, @ModelAttribute Showtime showtime,
                               @RequestParam int movieId, RedirectAttributes ra) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        showtime.setId(id);
        showtime.setMovie(movie);
        showtimeRepository.save(showtime);
        ra.addFlashAttribute("success", "แก้ไขรอบฉายสำเร็จ!");
        return "redirect:/admin/showtimes";
    }

    @PostMapping("/delete/{id}")
    public String deleteShowtime(@PathVariable Long id, RedirectAttributes ra) {
        showtimeRepository.deleteById(id);
        ra.addFlashAttribute("success", "ลบรอบฉายสำเร็จ");
        return "redirect:/admin/showtimes";
    }
}
