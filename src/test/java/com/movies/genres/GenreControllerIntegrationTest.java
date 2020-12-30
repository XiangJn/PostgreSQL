package com.movies.genres;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movies.genres.model.Genre;
import com.movies.genres.repository.GenreRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc

public class GenreControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GenreRepository GenreRepository;

    private Genre genre1 = new Genre("Action","Ac");
    private Genre genre2 = new Genre("Adventure","Ad");

    @BeforeEach
    public void beforeAllTests() {
        GenreRepository.deleteAll();
        GenreRepository.save(genre1);
        GenreRepository.save(genre2);
    }

    @AfterEach
    public void afterAllTests() {
        //Watch out with deleteAll() methods when you have other data in the test database!
        GenreRepository.deleteAll();
    }

    private ObjectMapper mapper = new ObjectMapper();

//    @Test
//    public void givenGenre_whenGetGenreByNameAndAbbreviation_thenReturnJsonReview() throws Exception {
//
//        mockMvc.perform(get("/genre/name/{name}/abbreviation/{abbreviation}", "Action", "Ac"))
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name", is("Action")))
//                .andExpect(jsonPath("$.abbreviation", is("Ac")));
//    }
    @Test
    public void givenGenre_whenGetGenreByName_thenReturnJsonReview() throws Exception {
        mockMvc.perform(get("/genre/name/{name}", "Action"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Action")))
                .andExpect(jsonPath("$.abbreviation", is("Ac")));
    }

    @Test
    public void givenGenre_whenGetGenreByAbbreviation_thenReturnJsonReview() throws Exception {
        mockMvc.perform(get("/genre/abbreviation/{abbreviation}", "Ad"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Adventure")))
                .andExpect(jsonPath("$.abbreviation", is("Ad")));
    }

}
