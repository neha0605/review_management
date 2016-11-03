package com.library.repository;

import com.library.repository.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by nehaojha on 10/10/16.
 */
public interface BookRepo extends JpaRepository<Book, Integer> {

    List<Book> findByBookName(String name);

    List<Book> findByPrice(double price);

}
