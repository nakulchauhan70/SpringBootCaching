package com.cacheable.cachemanager.dao;

import com.cacheable.cachemanager.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookDao extends CrudRepository<Book, Integer> {}
