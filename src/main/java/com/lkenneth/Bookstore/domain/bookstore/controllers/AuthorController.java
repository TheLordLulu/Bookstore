package com.lkenneth.Bookstore.domain.bookstore.controllers;
import com.lkenneth.Bookstore.domain.bookstore.models.Author;

import com.lkenneth.Bookstore.domain.bookstore.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        Author newAuthor = authorService.saveAuthor(author);
        return ResponseEntity.ok(newAuthor);
    }
    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorService.findAllAuthors();
        return ResponseEntity.ok(authors);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Author author = authorService.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
        return ResponseEntity.ok(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author authorDetails) {
        Author updatedAuthor = authorService.updateAuthor(id, authorDetails);
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
