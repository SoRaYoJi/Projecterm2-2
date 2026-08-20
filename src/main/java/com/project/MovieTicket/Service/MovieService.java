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

    // ดึงภาพยนตร์ทั้งหมด
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // ค้นหาภาพยนตร์ตามคำค้น
    public List<Movie> searchMovies(String query) {
        return movieRepository.findByMovienameContainingIgnoreCase(query);
    }

    public List<Movie> getRandomMovies(int count) {
        List<Movie> allMovies = movieRepository.findAll();
        Collections.shuffle(allMovies); // สุ่มลำดับ
        return allMovies.stream().limit(count).toList(); // คืนค่าจำนวนที่ต้องการ
    }
}
