package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {
//	here i make the string data member
    private String message;
	public HelloWorldBean(String message) {
		
		// TODO Auto-generated constructor stub
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
    
}
