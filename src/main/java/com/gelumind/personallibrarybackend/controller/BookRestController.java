package com.gelumind.personallibrarybackend.controller;

import com.gelumind.personallibrarybackend.model.Book;
import com.gelumind.personallibrarybackend.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BookRestController extends ApiRestController {
    @Autowired
    BookService bookService;

    // Get all books
    @GetMapping("/book/all")
    public List<Book> getAll() {
        return bookService.getAllBooks();
    }

    // Get book by ID
    @GetMapping("/book/{id}")
    public @ResponseBody
    Optional<Book> getBookById(@PathVariable Long id) {
        return bookService.getById(id);
    }

    // Get book by title
    @GetMapping("/book/title?{title}")
    public List<Book> getBookByTitle(@PathVariable String title) {
        return bookService.getByTitle(title.replace('+', ' '));
    }

    // Add book
    @PostMapping("/book/add")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

//    @PostMapping("/addBookAndAuthor")
//    public void addBookAndAuthor(@RequestBody RequestObject formosDuomenys) {
//        List<Author> authorList = formosDuomenys.getAuthorList();
//        author.setBookAuthors(authorList);
//
//        Author author = new Author();
//        Book book = new Book();
//        author.setAuthorName(requestObject.getAuthorName());
//        authorService.saveAuthor(author);
//        book.setBookTitle(requestObject.getBookTitle());
//        book.setAuthor(author.getId());
//        bookService.saveBook(book);
//    }

    // Update book
    @PutMapping("/book")
    public HttpStatus updateBook(@RequestBody Book book) {
        return bookService.updateBook(book) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
    }

    // Delete book
    @DeleteMapping("/book/{id}")
    public HttpStatus deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return HttpStatus.NO_CONTENT;
    }

    // Add author to book
    // Since book can have many authors we need this to add multiple authors
    // when adding a new book. Vice versa is not recommended
    @PutMapping("/book/{bookId}/author/{authorId}")
    public void addAuthor(@PathVariable Long bookId, @PathVariable Long authorId) {
        bookService.addAuthor(bookId, authorId);
    }

//    @GetMapping(path="/books", produces = "application/json")
//    public Books getBooks() {
//        Books response = new Books();
//        ArrayList<Book> list = new ArrayList<>();
//        bookRepository.findAll().forEach(e -> list.add(e));
//        response.setBookList(list);
//        return response;
//    }
}
