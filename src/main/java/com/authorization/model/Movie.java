package com.authorization.model;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class Movie {
    private int movieId;
    private String movieName;
    private String description;
    private String genre;
    private String language;
    private List<String> actors;
    private Date releaseDate;
}
