package com.project.MovieTicket.Repository;

import com.project.MovieTicket.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findByTitle(String title); // ค้นหาภาพยนตร์จากชื่อ

    List<Movie> findByTitleContaining(String title); // ค้นหาภาพยนตร์จากชื่อที่มีคำที่ต้องการค้นหา
}
