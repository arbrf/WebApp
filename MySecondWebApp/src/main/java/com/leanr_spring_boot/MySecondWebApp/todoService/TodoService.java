package com.leanr_spring_boot.MySecondWebApp.todoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.leanr_spring_boot.MySecondWebApp.todo.Todo;

import jakarta.validation.Valid;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todoscount=0;
    static {
        todos.add(new Todo(++todoscount, "in28minutes", "Learn Cloud", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoscount, "in28minutes", "Learn Devops", LocalDate.now().plusYears(3), false));
        todos.add(new Todo(++todoscount, "in28minutes", "Learn Full Stack Development", LocalDate.now().plusYears(2), false));
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

	public void addTodo(String username, String description, LocalDate plusWeeks, boolean b) {
		// TODO Auto-generated method stub
		Todo todo=new Todo(++todoscount, username, description, plusWeeks, b);
		todos.add(todo);
	}
	public void deleteTodo(int id) {
		// TODO Auto-generated method stub
		Predicate<Todo> predicate=(todo)->todo.getId()==id;
		
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
	    // Use stream to filter todos based on id
		Predicate<Todo> predicate=(todo)->todo.getId()==id;
	    return todos.stream()
	                .filter(predicate)
	                .findFirst() // Find the first matching Todo
	                .orElse(null); // If not found, return null
	}

	public void updateTodo(@Valid Todo todo) {
	    // Find the existing todo by id
	    Todo existingTodo = findById(todo.getId());
	    
	    if (existingTodo != null) {
	        // Update the existing todo with new values
	        existingTodo.setDescription(todo.getDescription());
	        existingTodo.setTargetDate(todo.getTargetDate());
	        existingTodo.setDone(todo.isDone());
	    }
	    // No need to delete the existing todo, as we're updating it in place
	    
	    // Optionally, you can add some error handling if the todo is not found
	}


    
}
