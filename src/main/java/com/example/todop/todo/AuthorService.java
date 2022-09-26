package com.example.todop.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private AuthorRepository repository;

    @Autowired
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<Author> getAuthors() {
        return repository.findAll();
    }

    public Author getAuthor(Long id) {
        Author author = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("author with id " + id + " does not exists."));

        return author;
    }
}
