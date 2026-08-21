package com.project.MovieTicket.Repository;

import com.project.MovieTicket.Entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    List<Showtime> findByMovieIdOrderByShowDateAscShowTimeAsc(int movieId);
    List<Showtime> findByCinemaContainingIgnoreCase(String cinema);
}
