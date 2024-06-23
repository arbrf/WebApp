package com.IN28MINUTES.rest.webservices.restful_web_servicrs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	@GetMapping("hello-wolrd")
	public String helloWorld() {
		return "HelloWorld";
	}
	
	@GetMapping("hello-wolrd-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
}
