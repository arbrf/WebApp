package com.IN28MINUTES.rest.webservices.restful_web_servicrs.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.IN28MINUTES.rest.webservices.restful_web_servicrs.repo.PostRepository;
import com.IN28MINUTES.rest.webservices.restful_web_servicrs.repo.UserRepository;
import com.IN28MINUTES.rest.webservices.restful_web_servicrs.user.Post;
import com.IN28MINUTES.rest.webservices.restful_web_servicrs.user.User;

import jakarta.persistence.PostRemove;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/jpa")
public class UserJpaResource {

	private UserRepository service;
	private PostRepository postRepository;

	public UserJpaResource(UserRepository service,PostRepository postRepository) {
		this.service = service;
		this.postRepository=postRepository;
	}

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = service.findById(id);

		if (user.isEmpty())
			throw new UserNotFoundException("id:" + id);
		EntityModel<User> entityModel=EntityModel.of(user.get());
		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		Optional<User> user = service.findById(id);

		if (user.isEmpty())
			throw new UserNotFoundException("id:" + id);
		service.deleteById(id);

	}
	
	@GetMapping("/users/{id}/post")
	public List<Post> findPostsByUserID(@PathVariable int id) {
		Optional<User> user = service.findById(id);

		if (user == null)
			throw new UserNotFoundException("id:" + id);
		
		return user.get().getPost();

	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {

		User savedUser = service.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	@PostMapping("/users/{id}/post")
	public ResponseEntity<Object> createPost(@PathVariable int id,@Valid @RequestBody Post post) {
		Optional<User> user = service.findById(id);
		post.setUser(user.get());
		Post savedPost = postRepository.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(savedPost.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

}