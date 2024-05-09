package com.lkenneth.Bookstore.domain.bookstore.services;

import com.lkenneth.Bookstore.domain.bookstore.models.Book;
import com.lkenneth.Bookstore.domain.bookstore.models.Review;
import com.lkenneth.Bookstore.domain.bookstore.repos.BookRepo;
import com.lkenneth.Bookstore.domain.bookstore.repos.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepo reviewRepo; // Interface for database operations concerning reviews.
    private final BookRepo bookRepo;

    // Constructor that Spring uses to inject an instance of ReviewRepository.
    @Autowired
    public ReviewService(ReviewRepo reviewRepo, BookRepo bookRepo) {
        this.reviewRepo = reviewRepo;
        this.bookRepo = bookRepo;
    }

    // Saves a review entity to the database and returns the persisted entity.
    public Review saveReview(Review review) {
        return reviewRepo.save(review);
    }

    // Finds a review by its ID. Returns an Optional indicating the review may or may not be found.
    public Optional<Review> findById(Long id) {
        return reviewRepo.findById(id);
    }

    // Retrieves all reviews stored in the database.
    public List<Review> findAllReviews() {
        return reviewRepo.findAll();
    }

    public Review saveReviewWithBook(Review review, Long bookId) {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));
        review.setBook(book);
        return reviewRepo.save(review);
    }

    // Updates an existing review identified by ID with new details from reviewDetails and returns the updated review.
    public Review updateReview(Long id, Review reviewDetails) {
        return reviewRepo.findById(id)
                .map(review -> {
                    review.setContent(reviewDetails.getContent());
                    review.setRating(reviewDetails.getRating());
                    return reviewRepo.save(review); // Save and return the updated review.
                }).orElseThrow(() -> new RuntimeException("Review not found!"));
    }

    // Deletes a review from the database using their ID.
    public void deleteReview(Long id) {
        reviewRepo.deleteById(id);
    }
}
