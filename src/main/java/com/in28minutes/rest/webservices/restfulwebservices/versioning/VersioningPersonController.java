package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//here i made the rest controller for implementing the versioning 
@RestController
public class VersioningPersonController {
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charlie");
	}
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
//	NOW I TELL ABOUT THE REQUEST PARAMETER VERSIONING 
	@GetMapping(path="/person",params="version=1")
	public PersonV1 getFirstVersionOfPersonRequestParameter() {
		return new PersonV1("Bob Charlie");
	}
	@GetMapping(path="/person",params="version=2")
	public PersonV2 getSecondVersionOfPersonRequestParameter() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
//	Here I tell about the concept of the Custom header-versioning 
//	url:localhost:8080/person/header 
//	in headers 
//	header Name:Bob
//	value: Charlie
	@GetMapping(path="/person/header",headers="X-API-VERSION=1")
public PersonV1 getFirstVersionOfPersonRequestHeader() {
	return new PersonV1("Bob Charlie");
}
//	Here I tell about the 
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonRequestHeader() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
//	here I perform the concept of the versioning rest api ----->Media type versioning 
//	In the header write Accept
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonAcceptHeader() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionOfPersonAcceptHeader() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
}
