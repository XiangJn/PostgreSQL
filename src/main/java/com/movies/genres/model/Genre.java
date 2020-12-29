package com.movies.genres.model;

import javax.persistence.*;

@Entity
public class Genre {

    @Id
    private int id;
    private int genreId;
    private String name;
    private String abbreviation ;

    public Genre(int genreId, String name, String abbreviation) {
        this.genreId = genreId;
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public Genre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}

