package com.project.MovieTicket.Service;

import com.project.MovieTicket.Entity.Movie;
import com.project.MovieTicket.Repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> searchMovies(String query) {
        if (query == null || query.isBlank()) {
            return movieRepository.findAll();
        }
        return movieRepository.findByTitleContainingIgnoreCase(query);
    }

    public List<Movie> getRandomMovies(int count) {
        List<Movie> allMovies = movieRepository.findAll();
        Collections.shuffle(allMovies);
        return allMovies.stream().limit(count).toList();
    }
}
