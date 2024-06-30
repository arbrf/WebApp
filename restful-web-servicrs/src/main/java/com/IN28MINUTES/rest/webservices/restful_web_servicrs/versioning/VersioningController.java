package com.IN28MINUTES.rest.webservices.restful_web_servicrs.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
@RestController
public class VersioningController {
	@GetMapping("/v1/person")
	public Personv1 personv1() {
		return new Personv1("Bob Charlie");
	}
	@GetMapping("/v2/person")
	public Personv2 personv2() {
		return new Personv2(new Name("Bob","Charlies"));
	}
	
	@GetMapping(path = "/person",params = "version=1")
	public Personv1 getFirstVersionFromPerson() {
		return new Personv1("Bob Charlie");
	}
	@GetMapping(path = "/person",params = "version=2")
	public Personv2 getSecondVersionFromPerson() {
		return new Personv2(new Name("Bob","Charlies"));
	}
	
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public Personv1 getFirstVersionFromPersonRequestHeader() {
        return new Personv1("Bob Charlie");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public Personv2 getSecondVersionFromPersonRequestHeader() {
        return new Personv2(new Name("Bob", "Charlies"));
    }
    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public Personv1 getFirstVersionFromPersonRequestAccept() {
        return new Personv1("Bob Charlie");
    }
    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public Personv2 getSecondVersionFromPersonRequestAccept() {
    	return new Personv2(new Name("Bob", "Charlies"));
    }
}
