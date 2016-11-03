package com.library.controller;

import com.library.repository.models.Book;
import com.library.repository.models.User;
import com.library.repository.models.view.UserViewModel;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by nehaojha on 25/10/16.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, headers = ACCEPT_JSON)
    public List<UserViewModel> getAllUsers() {
        return userService.findAllUsers().stream().map(UserViewModel::new).collect(Collectors.toList());
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET, headers = ACCEPT_JSON)
    public ResponseEntity<List<UserViewModel>> getUserByName(@PathVariable String name) {
        return new ResponseEntity<>(userService.findUserByName(name).stream().map(UserViewModel::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET, headers = ACCEPT_JSON)
    public Set<Book> getAllBooksByUser(@PathVariable String name) {
        List<User> users = this.userService.findUserByName(name);
        Set<Book> books = new HashSet<>();
        users.forEach(a -> books.addAll(a.getBooks()));
        return books;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST, headers = ACCEPT_JSON)
    public ResponseEntity addUser(@RequestBody User user) {
        if (user.getUserId() != null) {
            return new ResponseEntity("user already exists", HttpStatus.BAD_REQUEST);
        }
        userService.addUser(user);
        return new ResponseEntity("user added successfully", HttpStatus.CREATED);
    }

}
