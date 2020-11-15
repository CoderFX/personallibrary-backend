package com.gelumind.personallibrarybackend.repository;

import com.gelumind.personallibrarybackend.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Set<Author> findAll();
    Optional<Author> findById(Long author_id);
    Set<Author> findByFirstNameContaining(String firstName);
    Set<Author> findByLastNameContaining(String lastName);

}