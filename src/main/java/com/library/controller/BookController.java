package com.library.controller;

import com.library.repository.models.Book;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hojha on 16/10/16.
 */
@RestController
@RequestMapping(value = "/books")
public class BookController extends BaseController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET, headers = ACCEPT_JSON)
    public List<Book> getBooks() {
        return bookService.findAllBooks();
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET, headers = ACCEPT_JSON)
    public List<Book> getBooksByName(@PathVariable String name) {
        return bookService.findBookByName(name);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET, headers = ACCEPT_JSON)
    public Book getBooksById(@PathVariable Integer id) {
        return bookService.findBookById(id);
    }

    @RequestMapping(value = "/price", method = RequestMethod.GET, headers = ACCEPT_JSON)
    public List<Book> getBooksByPrice(@RequestParam(value = "price") double price) {
        return bookService.findBookByPrice(price);
    }

    @RequestMapping(method = RequestMethod.POST, headers = ACCEPT_JSON)
    public String addNewBook(@RequestBody Book book) {
        bookService.addBook(book);
        return "Book added successfully.";
    }

    @RequestMapping(method = RequestMethod.PUT, headers = ACCEPT_JSON)
    public ResponseEntity<String> updateBook(@RequestBody Book book) {
        try {
            bookService.updateBook(book);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Book updated successfully.", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = ACCEPT_JSON)
    public String deleteBookById(@PathVariable Integer id) {
        if (id == null || bookService.findBookById(id) == null) {
            return "no book found";
        }
        bookService.deleteById(id);
        return "Book deleted successfully.";
    }
}
