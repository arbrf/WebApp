package com.leanr_spring_boot.MySecondWebApp.logincontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leanr_spring_boot.MySecondWebApp.todo.Todo;
import com.leanr_spring_boot.MySecondWebApp.todoService.TodoService;

@Controller
public class TodoController {
    @Autowired
    TodoService todoService;

    @RequestMapping("/list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByuserName("in28minutes");
        model.put("todos", todos);
        return "listTodos";
    }
}
