package com.movies.genres.repository;

import com.movies.genres.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Integer> {
    Genre findGenreBynaam(String naam);
    List<Genre> findGenresByGenreContaining(String naam);
}
