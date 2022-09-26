package com.example.todop.todo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {

    @Mock
    AuthorRepository authorRepository;

    @InjectMocks
    AuthorService authorService;

    List<Author> authors;

    @BeforeEach
    void setUp() {
        // setup code
        authorService = mock(AuthorService.class);
        authors = Arrays.asList(
                new Author(1, "Ana", "ana@email.com", LocalDate.of(1997, Month.JANUARY, 12)),
                new Author(2, "Maria", "maria@gmail.com", LocalDate.of(1996, Month.FEBRUARY, 12))
        );

    }

    @AfterEach
    void tearDown() {
        // tear down code
    }

    @Test
    void getAuthors_shouldReturnAListOfAuthors() {
        Mockito.when(authorService.getAuthors()).thenReturn(authors);
        assertThat(authorService.getAuthors()).hasSizeGreaterThan(1);
    }

    @Test
    void getAuthor() {
        Mockito.when(authorService.getAuthor(any())).thenReturn(authors.get(0));
        assertThat(authorService.getAuthor(any())).isNotNull();
    }

}