package com.IN28MINUTES.rest.webservices.restful_web_servicrs.errror;

import java.time.LocalDateTime;

public class ErrorDetails {
	private LocalDateTime timestamp;
	private String message;
	private String description;

	public ErrorDetails(LocalDateTime timestamp, String message, String description) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.description = description;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}

}
