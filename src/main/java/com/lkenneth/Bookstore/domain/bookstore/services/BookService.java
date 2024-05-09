package com.lkenneth.Bookstore.domain.bookstore.services;

import com.lkenneth.Bookstore.domain.bookstore.models.Book;
import com.lkenneth.Bookstore.domain.bookstore.repos.BookRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo){
        this.bookRepo = bookRepo;
    }

    public Book saveBook(Book book){
        return bookRepo.save(book);
    }

    public Optional<Book> findById(Long id){
        return bookRepo.findById(id);
    }

    public List<Book> findAllBooks(){
        return bookRepo.findAll();
    }

    public Book updateBook(Long id, Book bookDetails) {
        return bookRepo.findById(id)
                .map(book -> {
                    book.setTitle(bookDetails.getTitle());
                    book.setAuthor(bookDetails.getAuthor());
                    book.setIsbn(bookDetails.getIsbn());
                    book.setPrice(bookDetails.getPrice());
                    book.setPublicationDate(bookDetails.getPublicationDate());
                    book.setGenre(bookDetails.getGenre());
                    return bookRepo.save(book); // Saves and returns the updated book.
                }).orElseThrow(() -> new RuntimeException("Book with ID " + id + " not found")); // Throws an exception if the book is not found.
    }
    @Transactional
    public void deleteBook(Long id){
        bookRepo.deleteAllById(id);
    }
}
