package com.IN28MINUTES.rest.webservices.restful_web_servicrs.controller;

import java.util.Locale;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	@Autowired
	private MessageSource messageSource;
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
	
	@GetMapping("hello-wolrd-bean-internationalization")
	public String helloWorldinternationalization() {
		Locale locale=LocaleContextHolder.getLocale();
		
		return  messageSource.getMessage("message.good.morning",null,"DefaultMessage",locale);
	}
	
}
