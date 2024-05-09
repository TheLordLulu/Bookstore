package com.lkenneth.Bookstore.domain.bookstore.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Setter
@Getter
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Review content cannot be blank")
    @Column(length = 2000) // Example length, adjust as needed
    private String content; // The text of the review

    @NotNull(message = "Rating is required")
    @Min(value = 1, message = "Rating should not be less than 1")
    @Max(value = 5, message = "Rating should not be greater than 5")
    private Integer rating; // Rating out of 5

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    @JsonBackReference
    private Book book; // The book this review is associated with




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Review() {
    }


}
