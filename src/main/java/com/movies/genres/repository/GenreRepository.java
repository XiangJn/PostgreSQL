package com.movies.genres.repository;

import com.movies.genres.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Integer> {
    List<Genre> findGenreByNameContains(String name);
    List<Genre> findGenreByAbbreviationContains(String abbreviation);
    List<Genre> findGenreByNameAndAbbreviation(String name,String abbreviation);
}