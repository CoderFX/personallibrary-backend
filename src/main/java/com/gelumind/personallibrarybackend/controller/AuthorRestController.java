package com.gelumind.personallibrarybackend.controller;

import com.gelumind.personallibrarybackend.model.Author;
import com.gelumind.personallibrarybackend.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class AuthorRestController extends ApiRestController {
    @Autowired
    AuthorService authorService;

    // Get all authors
    @GetMapping("/author/all")
    public Set<Author> getAll() {
        return authorService.getAllAuthors() ;
    }

    // Get author by ID
    // {{url}}/api/author?id=VALUE
    @GetMapping("/author/{id}")
    public @ResponseBody
    Optional<Author> getAuthorById(@PathVariable("id") Long id) {
        return authorService.getById(id);
    }

    // Get author by first name
    // {{url}}/api/author?firstName=VALUE
    @GetMapping("/author/firstName/{firstName}")
    public @ResponseBody
    Set<Author> getAuthorByFirstName(@PathVariable String firstName) {
        return authorService.getByFirstName(firstName.replace('+', ' ')) ;
    }

    // Get author by last name
    @GetMapping("/author/lastName/{lastName}")
    public @ResponseBody
    Set<Author> getAuthorByLastName(@PathVariable String lastName) {
        return authorService.getByLastName(lastName.replace('+', ' ')) ;
    }

    // Add author
    @PostMapping("/author/add")
    public void addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
    }

    // Update author
    @PutMapping("/author/update")
    public void updateAuthor(@RequestBody Author author) {
        authorService.updateAuthor(author);
    }

    // Delete Author by ID
    @DeleteMapping("/author/delete/{id}")
    public void deleteAuthor(@PathVariable("id") Long id) {
        authorService.deleteAuthor(id);
    }
}
