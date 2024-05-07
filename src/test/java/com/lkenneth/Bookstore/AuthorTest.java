package com.lkenneth.Bookstore;

import com.lkenneth.Bookstore.domain.bookstore.models.Author;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class AuthorTest {
    @Test
    void testAuthorCreation(){
        Author author = new Author();
        author.setName("John Doe");
        author.setBio("John's Biography.");

        assertThat(author.getName()).isEqualTo("John Doe");
        assertThat(author.getBio()).isEqualTo("John's Biography.");

    }
}
