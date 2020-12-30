package com.movies.genres;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.movies.genres.model.Genre;
import com.movies.genres.repository.GenreRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class GenreControllerUnitTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GenreRepository GenreRepository;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void givenReview_whenGetReviewByUserIdAndISBN_thenReturnJsonReview() throws Exception {
        Genre genre1 = new Genre("Action","Ac");
        Genre genre2 = new Genre("Adventure","Ad");


        given(GenreRepository.findGenreByNameContains("Action"));

        mockMvc.perform(get("/genre/name/{name}/abbreviation/{abbreviation}","Action","Ac"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Action")))
                .andExpect(jsonPath("$.abbreviation", is("Ac")));
    }


}
