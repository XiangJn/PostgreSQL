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

    @GetMapping("/genres/naam/{naam}")
    public List<Genre> getGenresByGenre(@PathVariable String naam) {
        return genreRepository.findGenresByGenreContaining(naam);
    }

    @GetMapping("/genres/{naam}")
    public Genre getGenreBynaam(@PathVariable String naam) {
        return genreRepository.findGenreBynaam(naam);
    }

    @PostConstruct
    public void fillDB(){
        if(genreRepository.count()==0) {
            genreRepository.save(new Genre("Action"));
            genreRepository.save(new Genre("Romance"));
        }

        System.out.println(genreRepository.findGenreBynaam("Action").getNaam());
    }
}
