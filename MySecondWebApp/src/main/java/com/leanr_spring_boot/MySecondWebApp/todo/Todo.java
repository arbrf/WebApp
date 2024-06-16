package com.leanr_spring_boot.MySecondWebApp.todo;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

public class Todo {
    private int id;
    private String username;
    @Size(min = 10,message = "Enter Atleast 10 characters")
    private String description;
    private LocalDate targetDate;
    private boolean done; // Changed from isDone to done

    public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
        super();
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    public int getId() {
        return id;
    }

      public String getUsername() {
            return username != null ? username : ""; // Return an empty string if username is null
        }

        // Other methods
    


    public String getDescription() {
        return description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public boolean isDone() { // Corrected getter name
        return done;
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

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public void setDone(boolean done) { // Corrected setter name
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
                + targetDate + ", done=" + done + "]";
    }
}
