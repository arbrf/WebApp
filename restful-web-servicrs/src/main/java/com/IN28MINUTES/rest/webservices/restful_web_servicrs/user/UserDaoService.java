package com.IN28MINUTES.rest.webservices.restful_web_servicrs.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users=new ArrayList<>();
	
	static {
		users.add(new User(1, "Adam",LocalDate.now().minusYears(30)));
		users.add(new User(2, "Eve",LocalDate.now().minusYears(25)));
		users.add(new User(3, "Jim",LocalDate.now().minusYears(20)));
		
		
	}
	public List<User> findAll(){
		return users;
	}
	
	public User findById(Integer id){
		Predicate<User> userById=user->user.getId().equals(id);
		return users.stream().filter(userById).findFirst().get();
	}
}
