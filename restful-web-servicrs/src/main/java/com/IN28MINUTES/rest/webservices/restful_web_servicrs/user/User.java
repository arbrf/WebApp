package com.IN28MINUTES.rest.webservices.restful_web_servicrs.user;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
@Entity
@Table(name = "user_details")
public class User {
	protected User() {}
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=2,message = "Name should have atleast 2 characters")
	private String name;
	@Past(message = "TheBirthDate Should be Past")
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	@OneToMany(mappedBy = "user")
	private List<Post> post;

	
	public User(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate +", Post"+post +"]";
	}

}
