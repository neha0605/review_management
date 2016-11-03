package com.library.repository.models.view;

import com.library.repository.models.Author;

/**
 * Created by nehaojha on 25/10/16.
 */
public class AuthorViewModel {

    private Integer authorId;

    private String name;

    private String address;

    public AuthorViewModel(Author author) {
        this.authorId = author.getAuthorId();
        this.name = author.getName();
        this.address = author.getAddress();
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AuthorViewModel{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
