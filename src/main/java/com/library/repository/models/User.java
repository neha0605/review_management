package com.library.repository.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by hojha on 23/10/16.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    private String email;

    private Integer userId;

    private String password;

    private String address;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "book_user", joinColumns = @JoinColumn(name = "email"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
