package com.movies.genres.model;

import javax.persistence.*;

@Entity
public class Genre {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String abbreviation ;

    public Genre() {
    }

    public Genre(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}

