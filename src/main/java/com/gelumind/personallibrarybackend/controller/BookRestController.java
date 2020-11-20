package com.gelumind.personallibrarybackend.controller;

import com.gelumind.personallibrarybackend.exception.BookNotFoundException;
import com.gelumind.personallibrarybackend.model.Book;
import com.gelumind.personallibrarybackend.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class BookRestController extends ApiRestController {
    @Autowired
    BookService bookService;

    // Get all books
    @GetMapping("/book/all")
    public Set<Book> getAll() {
        return bookService.getAllBooks();
    }

    // Get book by ID
    @GetMapping("/book/{id}")
    public @ResponseBody
    Optional<Book> getBookById(@PathVariable Long id) throws BookNotFoundException {
        Book book = bookService.getById(id)
                .orElseThrow(
                        () ->
                                new BookNotFoundException(String.format("Book with id %s not found", id))
                );
        return bookService.getById(id);
    }

    // Get book by title
    @GetMapping("/book/title?{title}")
    public Set<Book> getBookByTitle(@PathVariable String title) {
        return bookService.getByTitle(title.replace('+', ' '));
    }

    // Add book
    @PostMapping("/book/add")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
//        bookService.addAuthor(book.getBook_id(), author.getAuthor_id());
    }

    //TODO try to add book and author together
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
    @CrossOrigin(origins = "http://localhost:4200") // fix for CORS policy error
    @PutMapping("/book/{book_id}/edit")
    public void updateBook(@PathVariable("book_id") Long book_id, @RequestBody Book book) throws BookNotFoundException {
        bookService.updateBook(book);
    }

    //TODO if you wish to remove a book, you must first delete all its authors. Is that OK?

    // Delete book
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/book/{book_id}/delete")
    public void deleteBook(@PathVariable Long book_id) throws BookNotFoundException {
        bookService.deleteBook(book_id);
    }

    // Add author to book
    // Since book can have many authors we need this to add multiple authors
    // when adding a new book. Vice versa is not recommended
    @CrossOrigin(origins = "http://localhost:4200")
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
