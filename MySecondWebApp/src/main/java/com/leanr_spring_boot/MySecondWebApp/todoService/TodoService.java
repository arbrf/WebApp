package com.leanr_spring_boot.MySecondWebApp.todoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.leanr_spring_boot.MySecondWebApp.todo.Todo;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "in28minutes", "Learn Cloud", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2, "in28minutes", "Learn Devops", LocalDate.now().plusYears(3), false));
        todos.add(new Todo(3, "in28minutes", "Learn Full Stack Development", LocalDate.now().plusYears(2), false));
    }

    public List<Todo> findByuserName(String username) {
        List<Todo> filteredTodos = new ArrayList<>();
        for (Todo todo : todos) {
            if (todo.getUsername().equals(username)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
}
