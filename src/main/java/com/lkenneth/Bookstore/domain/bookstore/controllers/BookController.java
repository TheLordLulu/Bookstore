package com.lkenneth.Bookstore.domain.bookstore.controllers;

import com.lkenneth.Bookstore.domain.bookstore.models.Book;
import com.lkenneth.Bookstore.domain.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book newBook = bookService.saveBook(book);
        return ResponseEntity.ok(newBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        Book book = bookService.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found!"));

        return ResponseEntity.ok(book);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.findAllBooks();
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(books);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails){
        Book updatedBook = bookService.updateBook(id, bookDetails);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}

