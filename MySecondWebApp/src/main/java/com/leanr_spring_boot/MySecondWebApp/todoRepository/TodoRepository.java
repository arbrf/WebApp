package com.leanr_spring_boot.MySecondWebApp.todoRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leanr_spring_boot.MySecondWebApp.todo.Todo;
@Repository
public interface TodoRepository  extends JpaRepository<Todo,Integer>{

	 List<Todo> findByUsername(String username);

}
