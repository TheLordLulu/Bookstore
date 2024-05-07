package com.lkenneth.Bookstore;

import com.lkenneth.Bookstore.domain.bookstore.models.Review;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReviewTest {

    @Test
    void testReviewRating() {
        Review review = new Review();
        review.setContent("Great book!");
        review.setRating(5);

        assertThat(review.getContent()).isEqualTo("Great book!");
        assertThat(review.getRating()).isEqualTo(5);
    }
}
