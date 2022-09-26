package com.example.todop.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository repository;

    @Autowired
    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> getTodos() {
        return repository.findAll();
    }

    public Todo createTodo(Todo todo) {
        return repository.save(todo);
    }

    public List<Todo> getTodoByTitle(String title) {
        return repository.getTodoByTitleContains(title);
    }
}
