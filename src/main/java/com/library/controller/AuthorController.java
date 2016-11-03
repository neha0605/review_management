package com.library.controller;

import com.library.repository.models.Author;
import com.library.repository.models.Book;
import com.library.repository.models.view.AuthorViewModel;
import com.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by nehaojha on 25/10/16.
 */
@RestController
@RequestMapping(value = "/authors")
public class AuthorController extends BaseController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(method = RequestMethod.GET, headers = ACCEPT_JSON)
    public List<Author> getAllAuthors() {
        return authorService.findAllAuthors();
    }

    @RequestMapping(value = "/books/{name}", method = RequestMethod.GET, headers = ACCEPT_JSON)
    public Set<Book> getAllBooksByAuthor(@PathVariable String name) {
        List<Author> authors = this.authorService.findAuthorByName(name);
        Set<Book> books = new HashSet<>();
        authors.forEach(a -> books.addAll(a.getBooks()));
        return books;
    }

    @RequestMapping(value = "{name}", method = RequestMethod.GET, headers = ACCEPT_JSON)
    public List<Author> getAuthorByName(@PathVariable String name) {
        return authorService.findAuthorByName(name);
    }

    @RequestMapping(method = RequestMethod.POST, headers = ACCEPT_JSON)
    public ResponseEntity<String> addAuthor(@RequestBody Author author) {
        if (author.getAuthorId() != null) {
            return new ResponseEntity<String>("author already exists", HttpStatus.BAD_REQUEST);
        }
        authorService.addAuthor(author);
        return new ResponseEntity("author added successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/author/{authorid}", method = RequestMethod.GET, headers = ACCEPT_JSON)
    public AuthorViewModel getAuthorById(@PathVariable Integer authorid) {
        Author authorById = authorService.findAuthorById(authorid);
        return new AuthorViewModel(authorById);
    }

}
