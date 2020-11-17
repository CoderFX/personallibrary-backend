package com.gelumind.personallibrarybackend.repository;

import com.gelumind.personallibrarybackend.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Set<Book> findAll();
    Set<Book> findByTitleContaining(String title) ;
}