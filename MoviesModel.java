package com.project.MovieTicket.Model;

import jakarta.persistence.*;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id") // Mapping กับคอลัมน์ในฐานข้อมูล
    private Long movie_id;

    private String title;

    private String genre;

    private int duration;

    @Column(name = "release_date") // Mapping กับคอลัมน์ในฐานข้อมูล
    private Date release_date;

    private String description;

    @Column(name = "image_path") // Mapping กับคอลัมน์ในฐานข้อมูล
    private String image_path;

    // Getters and Setters
    public Long getMovieId() {
        return movie_id;
    }

    public void setMovieId(Long movieId) {
        this.movie_id = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getReleaseDate() {
        return release_date;
    }

    public void setReleaseDate(Date releaseDate) {
        this.release_date = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return image_path;
    }

    public void setImagePath(String imagePath) {
        this.image_path = imagePath;
    }
}
