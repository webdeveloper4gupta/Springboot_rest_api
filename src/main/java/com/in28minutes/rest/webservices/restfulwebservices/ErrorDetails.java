package com.in28minutes.rest.webservices.restfulwebservices;

import java.time.LocalDate;
//this class I have write to make the custom error 
import java.time.LocalDateTime;

public class ErrorDetails {
//     here i wwant 
//	timestamp
//	message
//	details
	private LocalDateTime timestamp;
	private String message;
	private String details;
	public ErrorDetails(LocalDateTime localDateTime, String message, String details) {
		super();
		this.timestamp = localDateTime;
		this.message = message;
		this.details = details;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	

}
