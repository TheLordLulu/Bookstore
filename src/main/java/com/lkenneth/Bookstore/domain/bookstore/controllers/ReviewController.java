package com.lkenneth.Bookstore.domain.bookstore.controllers;

import com.lkenneth.Bookstore.domain.bookstore.models.Review;
import com.lkenneth.Bookstore.domain.bookstore.models.ReviewDto;
import com.lkenneth.Bookstore.domain.bookstore.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody ReviewDto reviewDto) {
        Review newReview = new Review();
        newReview.setContent(reviewDto.getContent());
        newReview.setRating(reviewDto.getRating());

        // Assuming you handle the book association within the service
        Review savedReview = reviewService.saveReviewWithBook(newReview, reviewDto.getBookId());
        return ResponseEntity.ok(savedReview);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Review review = reviewService.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        return ResponseEntity.ok(review);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.findAllReviews();
        return ResponseEntity.ok(reviews);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review reviewDetails) {
        Review updatedReview = reviewService.updateReview(id, reviewDetails);
        return ResponseEntity.ok(updatedReview);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}