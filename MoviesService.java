package com.project.MovieTicket.Service;

import com.project.MovieTicket.Model.Movie;
import com.project.MovieTicket.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll(); // ดึงข้อมูลทั้งหมดจากฐานข้อมูล
    }

    public Movie getMovieByName(String name) {
        return movieRepository.findByTitle(name); // ค้นหาภาพยนตร์จากชื่อ
    }

    public List<Movie> searchMoviesByTitle(String title) {
        return movieRepository.findByTitleContaining(title); // ค้นหาภาพยนตร์จากชื่อที่ตรงหรือคล้ายกับที่ค้นหา
    }
    public List<Movie> getRandomMovies(int n) {
        List<Movie> allMovies = movieRepository.findAll(); // ดึงภาพยนตร์ทั้งหมด
        Collections.shuffle(allMovies); // สุ่มลำดับ
        return allMovies.stream() // ใช้ Stream API
                .limit(n) // จำกัดจำนวนผลลัพธ์
                .collect(Collectors.toList()); // รวมผลลัพธ์เป็น List
    }

}
