package com.library.service.impl;

import com.library.repository.BookRepo;
import com.library.repository.models.Book;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nehaojha on 10/10/16.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Override
    public List<Book> findAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public List<Book> findBookByName(String name) {
        return bookRepo.findByBookName(name);
    }

    @Override
    public Book findBookById(Integer id) {
        return bookRepo.findOne(id);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        if (book.getBookId() == null) {
            throw new RuntimeException("book id required to update");
        }
        Book bookById = findBookById(book.getBookId());
        if (bookById == null) {
            throw new RuntimeException("no found found for update");
        }
        bookById.setPrice(book.getPrice());
        bookById.setBookName(book.getBookName());
        bookById.setQuantity(book.getQuantity());
        return bookRepo.save(bookById);
    }

    @Override
    public void deleteById(Integer id) {
        bookRepo.delete(id);
    }

    @Override
    public List<Book> findBookByPrice(double price) {
        return bookRepo.findByPrice(price);
    }
}
