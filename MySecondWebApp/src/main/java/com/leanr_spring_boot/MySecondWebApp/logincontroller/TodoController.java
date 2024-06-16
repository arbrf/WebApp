package com.leanr_spring_boot.MySecondWebApp.logincontroller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@SessionAttributes("name")
public class TodoController {
    @Autowired
    TodoService todoService;

    @RequestMapping("/list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByuserName("in28minutes");
        model.put("todos", todos);
        return "listTodos";
    }
    
    @RequestMapping(value = "/add-todo",method = RequestMethod.GET)
    public String addnewTodo(ModelMap modelMap) {
    	String username = (String)modelMap.get("name");
        Todo todo=new Todo(1, username, "", LocalDate.now(), false);
        modelMap.put("todo", todo);
        return "todo";
    }
    @RequestMapping(value = "/add-todo",method = RequestMethod.POST)
    public String updatedTodos(ModelMap model,@Valid Todo todo,BindingResult result) {
    	if(result.hasErrors()) {
    		 return "todo";
    	}
        String username = (String)model.get("name");
        todoService.addTodo(username,todo.getDescription(),LocalDate.now().plusYears(1),false);
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
       String username = (String)model.get("name");
       todo.setUsername(username);
       todo.setTargetDate(LocalDate.now().plusYears(2));
       todoService.updateTodo(todo);
       return "redirect:list-todos";
   }
    
}
