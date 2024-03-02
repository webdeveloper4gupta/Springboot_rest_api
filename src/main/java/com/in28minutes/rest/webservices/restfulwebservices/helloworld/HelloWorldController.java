package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Expose the REST API
@RestController
public class HelloWorldController {
	
//	@RequestMapping(method=RequestMethod.GET,path="/hello-world")
//	public String helloWorld() {
//		return "Hello World";
//	}
	
//to specify the specific annotation for the get request  -------> for returning the string back
//	@GetMapping(path="/hello-world")
//	public String helloWorld() {
//		return "Hello World";
//	}
//	it is provided by the springboot
	private MessageSource messageSource;
//	constructor injection
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource=messageSource;
	}
	
	@GetMapping(path="/basicauth")
	public String basicAuthCheck() {
		return "Success";
	}
	
	
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World2";
	}
//	here i write the method that return the json back
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
//	here i make the concept of the path parameters 
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello World" +name);
	}
	
	@GetMapping(path="/hello-world-internationalized")
	public String helloWorldInternationalized() {
		Locale locale=LocaleContextHolder.getLocale();
//		first param -->message
//		second param -->variable
//      third param--> default message
		// forth param --> locale 
	return	messageSource.getMessage("good.morning.message",null,"default message",locale);
	
	}
}

