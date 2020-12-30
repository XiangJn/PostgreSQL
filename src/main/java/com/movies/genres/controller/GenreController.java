package com.movies.genres.controller;

import com.movies.genres.model.Genre;
import com.movies.genres.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class GenreController {



    @Autowired
    private GenreRepository genreRepository;

    @PostConstruct
    public void fillDB(){
        if(genreRepository.count()==0) {
            genreRepository.save(new Genre("Action","Ac"));
            genreRepository.save(new Genre("Romance","Ro"));
        }
        System.out.println("Genre test: " + genreRepository.findGenreByNameContains("Action"));
    }



    @GetMapping("/genre/name/{name}")
    public List<Genre> getGenreByName(@PathVariable String name) {
        return genreRepository.findGenreByNameContains(name);
    }

    @GetMapping("/genre/abbreviation/{abbreviation}")
    public List<Genre> getGenreByAbbreviation(@PathVariable String abbreviation) {
        return genreRepository.findGenreByAbbreviationContains(abbreviation);
    }

    @GetMapping("/genre/name/{name}/abbreviation/{abbreviation}")
    public List<Genre> getGenreByNameAndAbbreviation(@PathVariable String name,@PathVariable String abbreviation) {
        return genreRepository.findGenreByNameAndAbbreviation(name,abbreviation);
    }


}