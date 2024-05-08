package com.lkenneth.Bookstore.domain.bookstore.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    // Assume Author is another entity class that represents a book author
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    @NotBlank(message = "ISBN is required")
    private String isbn;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Double price;

    @PastOrPresent(message = "Publication date must be in the past or present")
    private LocalDate publicationDate;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Review> reviews = new HashSet<>();

    // Additional fields and methods

    public Book() {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    // Business logic methods

    /**
     * Calculates the average rating of the book based on reviews.
     * @return the average rating if reviews exist, otherwise returns 0.
     */
    public double calculateAverageRating() {
        if (reviews.isEmpty()) {
            return 0;
        }
        double sum = reviews.stream().mapToDouble(Review::getRating).sum();
        return sum / reviews.size();
    }

    // Add or remove reviews
    public void addReview(Review review) {
        reviews.add(review);
        review.setBook(this);
    }

    public void removeReview(Review review) {
        reviews.remove(review);
        review.setBook(null);
    }
    public enum Genre {
        FICTION, NON_FICTION, SCIENCE_FICTION, FANTASY, MYSTERY, ROMANCE, HORROR
    }



}


