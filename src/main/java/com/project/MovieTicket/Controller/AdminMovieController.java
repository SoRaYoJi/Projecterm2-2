package com.project.MovieTicket.Controller;

import com.project.MovieTicket.Entity.Movie;
import com.project.MovieTicket.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/movies")
public class AdminMovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public String listMovies(Model model) {
        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("movies", movies);
        return "admin/movies";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("editMode", false);
        return "admin/movie-form";
    }

    @PostMapping("/add")
    public String addMovie(@ModelAttribute Movie movie, RedirectAttributes ra) {
        movieRepository.save(movie);
        ra.addFlashAttribute("success", "เพิ่มภาพยนตร์ \"" + movie.getTitle() + "\" สำเร็จ!");
        return "redirect:/admin/movies";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found: " + id));
        model.addAttribute("movie", movie);
        model.addAttribute("editMode", true);
        return "admin/movie-form";
    }

    @PostMapping("/edit/{id}")
    public String editMovie(@PathVariable int id, @ModelAttribute Movie movie, RedirectAttributes ra) {
        movie.setId(id);
        movieRepository.save(movie);
        ra.addFlashAttribute("success", "แก้ไขภาพยนตร์ \"" + movie.getTitle() + "\" สำเร็จ!");
        return "redirect:/admin/movies";
    }

    @PostMapping("/delete/{id}")
    public String deleteMovie(@PathVariable int id, RedirectAttributes ra) {
        movieRepository.deleteById(id);
        ra.addFlashAttribute("success", "ลบภาพยนตร์สำเร็จ");
        return "redirect:/admin/movies";
    }
}
