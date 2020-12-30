package com.movies.genres.model;

import javax.persistence.*;

@Entity
public class Genre {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String abbreviation ;

    public Genre( String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public Genre() {
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

