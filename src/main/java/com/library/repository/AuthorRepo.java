package com.library.repository;

import com.library.repository.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by nehaojha on 10/10/16.
 */
public interface AuthorRepo extends JpaRepository<Author, Integer> {

    List<Author> findByName(String name);

    List<Author> findAll();

    Author findByAuthorId(Integer authorId);

}
