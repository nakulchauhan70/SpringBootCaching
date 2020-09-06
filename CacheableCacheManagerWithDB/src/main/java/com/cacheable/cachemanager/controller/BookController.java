package com.cacheable.cachemanager.controller;

import com.cacheable.cachemanager.entities.Book;
import com.cacheable.cachemanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book-management")
public class BookController {

    //After updating an object get all is not updated

    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping(value = "/book/getAll")
    public Iterable<Book> getAllBook() {
        return bookService.getAllBook();
    }

    @GetMapping(value = "/book/{bookId}")
    public Book getBookById(@PathVariable("bookId") Integer bookId) {
        return bookService.getBookById(bookId);
    }

    @DeleteMapping(value = "/book/{bookId}")
    public void deleteBookById(@PathVariable("bookId") Integer bookId) {
        bookService.deleteBookById(bookId);
    }

    @PutMapping(value = "/book/{bookId}/{version}")
    public Book updateBook(@PathVariable("bookId") Integer bookId, @PathVariable("version") Integer version) {
        return bookService.updateBook(bookId, version);
    }
}
