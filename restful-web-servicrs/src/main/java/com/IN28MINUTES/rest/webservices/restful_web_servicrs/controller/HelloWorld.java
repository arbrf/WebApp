package com.IN28MINUTES.rest.webservices.restful_web_servicrs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("hello-wolrd-bean-pathvariable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello there %s", name));
	}
	
}
