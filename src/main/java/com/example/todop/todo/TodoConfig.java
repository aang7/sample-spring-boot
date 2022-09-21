package com.example.todop.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class TodoConfig implements CommandLineRunner {

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    AuthorRepository repository;

    @Autowired
    public TodoConfig(AuthorRepository repository) {
        this.repository = repository;

    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("MyCommandLineRunner executed in Todo Config");
    }
}
