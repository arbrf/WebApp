package com.leanr_spring_boot.MySecondWebApp.todo;

import java.time.LocalDate;

import org.springframework.stereotype.Component;


public class Todo {
	int id;
	String username;
	String description;
	LocalDate targerDate;
	boolean isDone;

	public Todo(int id, String username, String description, LocalDate targerDate, boolean isDone) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targerDate = targerDate;
		this.isDone = isDone;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getTargerDate() {
		return targerDate;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTargerDate(LocalDate targerDate) {
		this.targerDate = targerDate;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targerDate="
				+ targerDate + ", isDone=" + isDone + "]";
	}

}
