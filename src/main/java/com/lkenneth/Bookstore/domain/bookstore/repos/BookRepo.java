package com.lkenneth.Bookstore.domain.bookstore.repos;

import com.lkenneth.Bookstore.domain.bookstore.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository <Book, Long> {

    void deleteAllById(Long id);
}
