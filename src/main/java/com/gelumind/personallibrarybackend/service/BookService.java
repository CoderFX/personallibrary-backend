package com.gelumind.personallibrarybackend.service;

import com.gelumind.personallibrarybackend.model.Author;
import com.gelumind.personallibrarybackend.model.Book;
import com.gelumind.personallibrarybackend.repository.AuthorRepository;
import com.gelumind.personallibrarybackend.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookService {
    @Autowired
    BookRepository bookRepository ;

    @Autowired
    AuthorRepository authorRepository ;

    public Set<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getById(Long id) {
        return bookRepository.findById(id) ;
    }

    public Set<Book> getByTitle(String title) {
        return bookRepository.findByTitleContaining(title);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public boolean updateBook(Book book) {
        bookRepository.save(book);
        return true;
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public void addAuthor(Long bookId, Long authorId) {
        Optional<Book> book ;
        if((book = bookRepository.findById(bookId)).isPresent())
        {
            Optional<Author> author ;
            if((author = authorRepository.findById(authorId)).isPresent())
            {
                author.get().setBooks(book.get());
                authorRepository.save(author.get());
            }
        }
    }
}
