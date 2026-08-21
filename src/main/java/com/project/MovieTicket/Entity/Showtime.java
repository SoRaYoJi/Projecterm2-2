package com.project.MovieTicket.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "showtimes")
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @Column(nullable = false)
    private String cinema;

    @Temporal(TemporalType.DATE)
    @Column(name = "show_date", nullable = false)
    private Date showDate;

    @Column(name = "show_time", nullable = false)
    private String showTime;

    private String hall = "Hall 1";

    @Column(precision = 8, scale = 2)
    private double price = 250.0;

    @Column(name = "total_seats")
    private int totalSeats = 60;

    @Column(name = "available_seats")
    private int availableSeats = 60;

    public Showtime() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }

    public String getCinema() { return cinema; }
    public void setCinema(String cinema) { this.cinema = cinema; }

    public Date getShowDate() { return showDate; }
    public void setShowDate(Date showDate) { this.showDate = showDate; }

    public String getShowTime() { return showTime; }
    public void setShowTime(String showTime) { this.showTime = showTime; }

    public String getHall() { return hall; }
    public void setHall(String hall) { this.hall = hall; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getTotalSeats() { return totalSeats; }
    public void setTotalSeats(int totalSeats) { this.totalSeats = totalSeats; }

    public int getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }
}
