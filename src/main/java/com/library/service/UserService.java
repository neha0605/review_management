package com.library.service;

import com.library.repository.models.Book;
import com.library.repository.models.User;

import java.util.List;
import java.util.Set;

/**
 * Created by hojha on 23/10/16.
 */
public interface UserService {

    void addUser(User user);

    User findUser(String email, String password);

    List<User> findAllUsers();

    User findUserById(Integer userId);

    List<User> findUserByName(String name);

    User findUserByEmail(String email);

    Set<Book> findBookByUser(String name);
}
