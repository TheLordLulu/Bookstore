package com.lkenneth.Bookstore.domain.bookstore.services;

import com.lkenneth.Bookstore.domain.bookstore.models.Author;
import com.lkenneth.Bookstore.domain.bookstore.repos.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepo authorRepo; // Interface for database operations concerning authors.

    // Constructor that Spring uses to inject an instance of AuthorRepository.
    @Autowired
    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    // Saves an author entity to the database and returns the persisted entity.
    public Author saveAuthor(Author author) {
        return authorRepo.save(author);
    }

    // Finds an author by their ID. Returns an Optional indicating the author may or may not be found.
    public Optional<Author> findById(Long id) {
        return authorRepo.findById(id);
    }

    // Retrieves all authors stored in the database.
    public List<Author> findAllAuthors() {
        return authorRepo.findAll();
    }

    // Updates an existing author identified by ID with new details from authorDetails and returns the updated author.
    public Author updateAuthor(Long id, Author authorDetails) {
        return authorRepo.findById(id)
                .map(author -> {
                    author.setName(authorDetails.getName());
                    author.setBio(authorDetails.getBio());
                    return authorRepo.save(author); // Save and return the updated author.
                }).orElseThrow(() -> new RuntimeException("Author not found!"));
    }

    // Deletes an author from the database using their ID.
    public void deleteAuthor(Long id) {
        authorRepo.deleteById(id);
    }
}
