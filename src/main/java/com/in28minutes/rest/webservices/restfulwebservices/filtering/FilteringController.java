package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	
	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
//		here i write the concept of the dynamic filtering 
		SomeBean someBean=new SomeBean("value1","value2","value3");
		MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}

//	here i implement the concept of the static filtering
//	@GetMapping("/filtering-list")
//	public List<SomeBean> filteringList() {
//		return Arrays.asList (new SomeBean("value1","value2","value3"),new SomeBean("value4","value5","value6"));
//	}
	
//	here i write the logic for the dynamic filtering
	@GetMapping("/filtering-list") //field2, field3
	public MappingJacksonValue filteringList() {
		List<SomeBean> list = Arrays.asList(new SomeBean("value1","value2", "value3"),
				new SomeBean("value4","value5", "value6"));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		
		SimpleBeanPropertyFilter filter = 
				SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		
		FilterProvider filters = 
				new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		
		mappingJacksonValue.setFilters(filters );
		
		
		return mappingJacksonValue;
	}
}
