package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import jakarta.validation.Valid;
@RestController
public class UserResource {
	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		this.service=service;
	}
	
//	GET /users  ------>to return all the users that we created
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
//to return the single user
//	@GetMapping("/users/{id}")
//	public User retrieveUser(@PathVariable int id) {
//		User user=service.findOne(id);
//		if(user==null) {
////			if we not able to find the user then it return error
//			throw new UserNotFoundException("id:"+id);
//		}
//		return user;
//	}
	
	
	
	
//	now i make the post request to create the user 
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser=service.save(user);
//		here I also we return the user url that is created now
//		/users/4
//		for this we use location header 
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();   
//		to return the status that user is created 
		return ResponseEntity.created(location).build();
	}
	
	
	
	
//	Here I write the method for deleting the user 
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id);
	}
	
	
	
//	Here I implement the concept of the HATEOS
//	EntityModel 
//	 WebMvcLinkBuilder 
//	both  are the most important concept of the HATEOAS
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user=service.findOne(id);
		if(user==null) {
//			if we not able to find the user then it return error
			throw new UserNotFoundException("id:"+id);
		}
//		basically we wrap the user into the EntityModel 
		EntityModel<User> entityModel=EntityModel.of(user);
//here i link the url of the retrieveAllUsers with  this class
		WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retrieveAllUsers()); //linkTo(pointerMethod)
		entityModel.add(link.withRel("all-users"));
	
		return entityModel;
	}
	
}
