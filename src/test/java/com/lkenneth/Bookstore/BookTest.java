package com.lkenneth.Bookstore;

import com.lkenneth.Bookstore.domain.bookstore.models.Book;
import com.lkenneth.Bookstore.domain.bookstore.models.Review;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


import java.time.LocalDate;

public class BookTest {
    private Book book;


    @BeforeEach
    void setUp() {
        book = new Book();
    }

    @Test
    void TestNewBookCreation(){
        book.setTitle("1984");
        book.setIsbn("978-045");
        book.setPrice(19.99);
        book.setPublicationDate(LocalDate.now());
        book.setGenre(Book.Genre.FICTION);

        assertThat(book.getTitle()).isEqualTo("1984");
        assertThat(book.getIsbn()).isEqualTo("978-045");
        assertThat(book.getPrice()).isEqualTo(19.99);
        assertThat(book.getPublicationDate()).isEqualTo(LocalDate.now());
        assertThat(book.getGenre()).isEqualTo(Book.Genre.FICTION);
    }

    @Test
    void calculateAverageRatingWithNoReview(){
        double average = book.calculateAverageRating();
        assertThat(average).isEqualTo(0.0);
    }
    @Test
    void calculateAverageRatingWithReview(){
        Review review1 = new Review();
        review1.setRating(4);
        book.addReview(review1);

        Review review2 = new Review();
        review2.setRating(5);
        book.addReview(review2);

        double average = book.calculateAverageRating();
        assertThat(average).isEqualTo(4.5);
    }



}
