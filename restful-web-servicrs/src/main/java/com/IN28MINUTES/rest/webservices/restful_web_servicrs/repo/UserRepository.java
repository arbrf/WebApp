package com.IN28MINUTES.rest.webservices.restful_web_servicrs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IN28MINUTES.rest.webservices.restful_web_servicrs.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
