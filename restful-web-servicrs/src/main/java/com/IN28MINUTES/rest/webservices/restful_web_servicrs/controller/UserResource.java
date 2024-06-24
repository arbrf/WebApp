package com.IN28MINUTES.rest.webservices.restful_web_servicrs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.IN28MINUTES.rest.webservices.restful_web_servicrs.user.User;
import com.IN28MINUTES.rest.webservices.restful_web_servicrs.user.UserDaoService;

@RestController
public class UserResource {
	private UserDaoService service;

	public UserResource(UserDaoService service) {
		super();
		this.service = service;
	}
	@GetMapping("/users")
   private List<User> retrieveAllUsers(){
	   
	   return service.findAll();
   }
	
	@GetMapping("/users/{id}")
	   private User retrieveAllUsers(@PathVariable Integer id){
		   
		   return service.findById(id);
	   }
}
