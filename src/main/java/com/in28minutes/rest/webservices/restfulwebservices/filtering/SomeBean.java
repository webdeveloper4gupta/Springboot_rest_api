package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//here i write the concept of removing the field1 and field2
//@JsonIgnoreProperties({"field1","field2"})
//Here I perform the concept of the static filtering

//here i write for the dynamic filtering concept 
@JsonFilter("SomeBeanFilter")
public class SomeBean {
  private String field1;
//  static filtering concept
//  @JsonIgnore
  private String field2;
  private String field3;
public SomeBean(String field1, String field2, String field3) {
	super();
	this.field1 = field1;
	this.field2 = field2;
	this.field3 = field3;
}
public String getField1() {
	return field1;
}
public String getField2() {
	return field2;
}
public String getField3() {
	return field3;
}
@Override
public String toString() {
	return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
}
  
  
}
