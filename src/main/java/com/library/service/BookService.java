package com.library.service;

import com.library.repository.models.Book;

import java.util.List;

/**
 * Created by nehaojha on 10/10/16.
 */
public interface BookService {

    List<Book> findAllBooks();

    List<Book> findBookByName(String name);

    Book findBookById(Integer id);

    Book addBook(Book book);

    Book updateBook(Book book);

    void deleteById(Integer id);

    List<Book> findBookByPrice(double price);
}
