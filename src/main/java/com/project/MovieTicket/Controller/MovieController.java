package com.project.MovieTicket.Controller;

import com.project.MovieTicket.Entity.Movie;
import com.project.MovieTicket.Entity.SearchMovies;
import com.project.MovieTicket.Service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String showMovies(@ModelAttribute("search") SearchMovies search, Model model) {
        List<Movie> movies;
        // ตรวจสอบว่ามีคำค้นหาไหม
        if (search.getQuery() != null && !search.getQuery().isEmpty()) {
            movies = movieService.searchMovies(search.getQuery()); // ค้นหาภาพยนตร์
        } else {
            movies = movieService.getAllMovies(); // แสดงภาพยนตร์ทั้งหมด
        }
        model.addAttribute("movies", movies); // ส่งข้อมูลภาพยนตร์ไปยัง View
        return "movies"; // ชื่อไฟล์ HTML
    }

    @GetMapping("/home")
    public String home(Model model) {
        // ดึงภาพยนตร์สุ่ม 3 เรื่อง
        List<Movie> randomMovies = movieService.getRandomMovies(3);

        // ส่งข้อมูลภาพยนตร์ไปยัง view
        model.addAttribute("movies", randomMovies);

        // ส่งไปยังหน้า home.html
        return "home";
    }
}
