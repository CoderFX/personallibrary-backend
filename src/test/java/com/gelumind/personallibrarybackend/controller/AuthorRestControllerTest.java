package com.gelumind.personallibrarybackend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gelumind.personallibrarybackend.model.Author;
import com.gelumind.personallibrarybackend.repository.AuthorRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// https://mkyong.com/spring-boot/spring-rest-integration-test-example/

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class AuthorRestControllerTest {
    private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorRepository mockRepository;

    @Before
    public void init() {
        Author author = new Author("Autorius", "Pavarde");
        when(mockRepository.findById(1L)).thenReturn(Optional.of(author));
    }

//    @Test
//    void getAll() throws Exception {
//        Set<Author> authors = Arrays.asList(
//                new Author("FirstName1", "LastName1"),
//                new Author("FirstName2", "LastName2")
//        );
//
//        when(mockRepository.findAll()).thenReturn(authors);
//
//        mockMvc.perform(get("/api/authors"))
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].firstName", is("FirstName1")))
//                .andExpect(jsonPath("$[0].lastName", is("LastName1")))
//                .andExpect(jsonPath("$[1].firstName", is("FirstName2")))
//                .andExpect(jsonPath("$[1].lastName", is("LastName2")));
//
//        verify(mockRepository, times(1)).findAll();
//    }

    @Test
    void getAuthorById() throws Exception {
        mockMvc.perform(get("/api/author/?id=1"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id", is(null)))
                .andExpect(jsonPath("$.firstName", is("Autorius")))
                .andExpect(jsonPath("$.lastName", is("Pavarde")));

        verify(mockRepository, times(1)).findById(1L);
    }

    @Test
    void getAuthorByFirstName() {
    }

    @Test
    void getAuthorByLastName() {
    }

    @Test
    void addAuthor() {
    }

    @Test
    void updateAuthor() {
    }

    @Test
    void deleteAuthor() {
    }

    private static void printJSON(Object object) {
        String result;
        try {
            result = om.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            System.out.println(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}