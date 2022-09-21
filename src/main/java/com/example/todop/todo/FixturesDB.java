package com.example.todop.todo;

import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;

public class FixturesDB {

    /**
     * initial dummy data for experimental purposes.
     * @param applicationContext
     */
    public static void initData(ConfigurableApplicationContext applicationContext) {
        AuthorRepository authorRepository =  applicationContext.getBean(AuthorRepository.class);
        Author a1 = new Author("Someone", "some_email@email.com", LocalDate.of(1997, Month.JANUARY, 12));
        Author a2 = new Author("Abel", "aang.drummer@gmail.com", LocalDate.of(1996, Month.JANUARY, 12));
        authorRepository.saveAll(Arrays.asList(a1, a2));

        TodoRepository todoRepository =  applicationContext.getBean(TodoRepository.class);
        Todo t1 = new Todo("content x", "title x", a1);
        Todo t2 = new Todo("content x ", "title y", a1);
        todoRepository.saveAll(Arrays.asList(t1, t2));

        a1.setTodos(Collections.singleton(t1));
        a2.setTodos(Collections.singleton(t2));
        authorRepository.saveAll(Arrays.asList(a1, a2));
    }
}
