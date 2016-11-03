package com.library.service.impl;

import com.library.repository.models.Author;
import com.library.repository.models.Book;
import com.library.repository.AuthorRepo;
import com.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by nehaojha on 10/10/16.
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    public Author addAuthor(Author author) {

        return authorRepo.save(author);
    }

    @Override
    public void deleteAuthor(Author author) {
        authorRepo.delete(author);
    }

    @Override
    public Set<Book> findBookByAuthor(String name) {
        List<Author> authors = this.authorRepo.findByName(name);
        Set<Book> books = new HashSet<>();
        authors.forEach(a -> {
            books.addAll(a.getBooks());
        });
        return books;
    }

    public List<Author> findAuthorByName(String name) {
        return authorRepo.findByName(name);
    }

    @Override
    public Author findAuthorById(Integer authorId) {
        return authorRepo.findOne(authorId);
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorRepo.findAll();
    }
}
