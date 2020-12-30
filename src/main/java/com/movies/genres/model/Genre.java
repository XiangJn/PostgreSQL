package com.movies.genres.model;

import javax.persistence.*;

@Entity
public class Genre {

    @Id
    private int id;
    private String name;
    private String abbreviation ;

    public Genre( String name, String abbreviation) {
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

