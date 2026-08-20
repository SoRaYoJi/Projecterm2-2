package com.project.MovieTicket.Entity;

public class SearchMovies {

    private String query; // คำค้นหา

    // Constructor
    public SearchMovies() {}

    public SearchMovies(String query) {
        this.query = query;
    }

    // Getter และ Setter
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
