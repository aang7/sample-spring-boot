package com.example.todop;

import com.example.todop.todo.*;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TodopApplicationTests {

	@Autowired
	private AuthorService authorService;
	@Autowired
	private TodoService todoService;

	@Test
	void getTwoTodosAvailableWhenGetTodoByTitle() {
		List<Todo> todos = todoService.getTodoByTitle("title");
		assertThat(todos).hasSize(2);
	}

	@Test
	void getAtLeastOneAuthor() {
		assertThat(authorService.getAuthors()).hasSizeGreaterThan(0);
	}
}
