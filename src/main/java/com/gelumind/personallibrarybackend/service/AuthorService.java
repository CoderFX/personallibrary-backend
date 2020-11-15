package com.gelumind.personallibrarybackend.service;

import com.gelumind.personallibrarybackend.model.Author;
import com.gelumind.personallibrarybackend.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthorService {
    @Autowired
    private final AuthorRepository authorRepository;

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public Optional<Author> getById(Long id) {
        return authorRepository.findById(id) ;
    }

    public Set<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Set<Author> getByFirstName(String firstName) {
        Set<Author> authors;
        authors = authorRepository.findByFirstNameContaining(firstName) ;
        return authors;
    }

    public Set<Author> getByLastName(String lastName) {
        return authorRepository.findByLastNameContaining(lastName);
    }

    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}

