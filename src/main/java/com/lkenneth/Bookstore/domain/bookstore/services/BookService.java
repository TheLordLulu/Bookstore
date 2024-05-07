package com.lkenneth.Bookstore.domain.bookstore.services;

import com.lkenneth.Bookstore.domain.bookstore.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class BookService {

    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo){
        this.bookRepo = bookRepo;
    }

}
