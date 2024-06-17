package com.leanr_spring_boot.MySecondWebApp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurtiyConfiguration {
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		

		UserDetails userDetails = createNewUser("in28minutes", "dummy");
		UserDetails userDetails1 = createNewUser("ranga", "dummydummy");
		
		return  new InMemoryUserDetailsManager(userDetails,userDetails1);
		
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder=input->passwordEncoders().encode(input);
		UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder)
				.username(username).password(password).roles("USER","ADMIN").build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoders() {
		
		return new BCryptPasswordEncoder();
		
	}
}

