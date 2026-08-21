package com.project.MovieTicket.Controller;

import com.project.MovieTicket.Entity.Movie;
import com.project.MovieTicket.Entity.Showtime;
import com.project.MovieTicket.Repository.MovieRepository;
import com.project.MovieTicket.Repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
public class MovieController {

    @Autowired private MovieRepository movieRepository;
    @Autowired private ShowtimeRepository showtimeRepository;

    @GetMapping("/home")
    public String home(Model model) {
        List<Movie> nowShowing = movieRepository.findByIsNowShowingTrue();
        Collections.shuffle(nowShowing);
        model.addAttribute("featuredMovie", nowShowing.isEmpty() ? null : nowShowing.get(0));
        model.addAttribute("movies", nowShowing.stream().limit(8).toList());
        return "home";
    }

    @GetMapping("/movies")
    public String movies(@RequestParam(value = "q", required = false) String query,
                         @RequestParam(value = "genre", required = false) String genre,
                         Model model) {
        List<Movie> movies;
        if (query != null && !query.isBlank()) {
            movies = movieRepository.findByTitleContainingIgnoreCase(query);
        } else if (genre != null && !genre.isBlank()) {
            movies = movieRepository.findByGenreContainingIgnoreCase(genre);
        } else {
            movies = movieRepository.findAll();
        }
        model.addAttribute("movies", movies);
        model.addAttribute("query", query);
        model.addAttribute("genre", genre);
        return "movies";
    }

    @GetMapping("/movies/{id}")
    public String movieDetail(@PathVariable int id, Model model) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found: " + id));
        List<Showtime> showtimes = showtimeRepository.findByMovieIdOrderByShowDateAscShowTimeAsc(id);
        model.addAttribute("movie", movie);
        model.addAttribute("showtimes", showtimes);
        return "movie-detail";
    }
}
