package com.library.service;

import com.library.repository.models.Author;
import com.library.repository.models.Book;

import java.util.List;
import java.util.Set;

/**
 * Created by nehaojha on 10/10/16.
 */
public interface AuthorService {

    Author addAuthor(Author author);

    void deleteAuthor(Author author);

    Set<Book> findBookByAuthor(String name);

    List<Author> findAllAuthors();

    List<Author> findAuthorByName(String name);

    Author findAuthorById(Integer authorId);
}
