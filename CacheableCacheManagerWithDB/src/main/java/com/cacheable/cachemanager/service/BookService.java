package com.cacheable.cachemanager.service;

import com.cacheable.cachemanager.dao.BookDao;
import com.cacheable.cachemanager.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public Book addBook(Book book) {
        return bookDao.save(book);
    }

    @Cacheable(value = "bookCache", key = "#bookId", unless = "#result==null")
    public Book getBookById(Integer bookId) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        Optional<Book> optionalBook = bookDao.findById(bookId);
        return optionalBook.orElse(null);
    }

    @Cacheable(value = "bookCache")
    public Iterable<Book> getAllBook() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        return bookDao.findAll();
    }

    @CacheEvict(value = "bookCache", key = "#bookId")
    public void deleteBookById(Integer bookId) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        bookDao.deleteById(bookId);
    }

    @CachePut(value = "bookCache", key = "#bookId")
    public Book updateBook(Integer bookId, Integer version) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        Optional<Book> optionalBook = bookDao.findById(bookId);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setVersion(version);
            return bookDao.save(book);
        }

        return null;
    }
}
