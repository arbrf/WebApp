package com.leanr_spring_boot.MySecondWebApp.logincontroller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.leanr_spring_boot.MySecondWebApp.todo.Todo;
import com.leanr_spring_boot.MySecondWebApp.todoService.TodoService;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoJpaController {
    @Autowired
    TodoService todoService;

    @RequestMapping("/list-todos")
    public String listAllTodos(ModelMap model) {
    	 String username = getLoggedInUserName(model);
        List<Todo> todos = todoService.findByuserName(username);
        model.put("todos", todos);
        return "listTodos";
    }

	private String getLoggedInUserName(ModelMap model) {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
    
    @RequestMapping(value = "/add-todo",method = RequestMethod.GET)
    public String addnewTodo(ModelMap modelMap) {
    	String username = getLoggedInUserName(modelMap);
        Todo todo=new Todo(1, username, "", LocalDate.now(), false);
        modelMap.put("todo", todo);
        return "todo";
    }
    @RequestMapping(value = "/add-todo",method = RequestMethod.POST)
    public String updatedTodos(ModelMap model,@Valid Todo todo,BindingResult result) {
    	if(result.hasErrors()) {
    		 return "todo";
    	}
        String username = getLoggedInUserName(model);
        System.out.println("Apple");
        System.out.println(todo.toString());
        todoService.addTodo(username,todo.getDescription(),todo.getTargetDate(),false);
        return "redirect:list-todos";
    }
    
    @RequestMapping(value = "/delete-todo",method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
    	todoService.deleteTodo(id);
        return "redirect:list-todos";
    }
    @RequestMapping(value = "/update-todo",method = RequestMethod.GET)
    public String updateTodo(@RequestParam int id,ModelMap map) {
    Todo todo=	todoService.findById(id);
    map.put("todo", todo);
        return "todo";
    }
    @RequestMapping(value = "/update-todo",method = RequestMethod.POST)
    public String updatenewTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
    	if(result.hasErrors()) {
   		 return "todo";
   	}
       String username = getLoggedInUserName(model);
       todo.setUsername(username);
       
       todoService.updateTodo(todo);
       return "redirect:list-todos";
   }
    
}
