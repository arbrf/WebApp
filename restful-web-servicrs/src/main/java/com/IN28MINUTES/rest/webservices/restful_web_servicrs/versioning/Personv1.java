package com.IN28MINUTES.rest.webservices.restful_web_servicrs.versioning;

public class Personv1 {
private String message;

public Personv1(String message) {
	super();
	this.message = message;
}

public String getMessage() {
	return message;
}

@Override
public String toString() {
	return "Personv1 [message=" + message + "]";
}

}
