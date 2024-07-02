package com.IN28MINUTES.rest.webservices.restful_web_servicrs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IN28MINUTES.rest.webservices.restful_web_servicrs.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
