package com.lkenneth.Bookstore.domain.bookstore.models;

public class ReviewDto {

    private String content;
    private Integer rating;
    private Long bookId;  // ID of the book to which the review pertains

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
