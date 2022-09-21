package com.example.todop.todo;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Order(2)
@Component
public class AuthorConfig implements CommandLineRunner {

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    AuthorRepository repository;

    @Autowired
    public AuthorConfig(AuthorRepository repository) {
        this.repository = repository;
    }

    // @Bean
    // CommandLineRunner commandLineRunner(AuthorRepository repository) {
    //     return args -> {
    //         Author a1 = new Author(1L, "random name", "email", LocalDate.of(1997, Month.JANUARY, 12));
    //         Todo t1 = new Todo(1L, "contenido x ", "titulo x");
    //         a1.setTodos(Collections.singleton(t1));
    //         repository.saveAll(Arrays.asList(a1));
    //     };
    // }

    @Override
    public void run(String... args) throws Exception {
        logger.info("MyCommandLineRunner executed in Author Config");
    }
}
