package com.lkenneth.Bookstore.domain.bookstore.repos;

import com.lkenneth.Bookstore.domain.bookstore.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Long> {
}
