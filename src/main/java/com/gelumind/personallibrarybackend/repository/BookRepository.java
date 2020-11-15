package com.gelumind.personallibrarybackend.repository;

import com.gelumind.personallibrarybackend.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Set<Book> findAll();
    Set<Book> findByTitleContaining(String title) ;
}