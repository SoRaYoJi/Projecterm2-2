package com.project.MovieTicket.Repository;

import com.project.MovieTicket.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    // ค้นหาโดย moviename (Case-Insensitive)
    List<Movie> findByMovienameContainingIgnoreCase(String moviename);
}
