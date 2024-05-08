package com.lkenneth.Bookstore.domain.bookstore.repos;

import com.lkenneth.Bookstore.domain.bookstore.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository <Review, Long> {
}
