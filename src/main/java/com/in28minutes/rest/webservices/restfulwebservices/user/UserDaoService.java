package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
//    JPA/HIBERNATE --> USED TO PLAY WITH THE DATABASE
//BUT NOW WE USED STATIC LIST TO TALK WITH THE DATABASE 
	private static List<User> users=new ArrayList<>();
	private  static int usersCount=0;
	
	static {
		users.add(new User(++usersCount,"Adam",LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount,"Eve",LocalDate.now().minusYears(25)));
		users.add(new User(++usersCount,"Jim",LocalDate.now().minusYears(20)));
	}
//	to find all the users 
	public List<User> findAll() {
		return users;
	}
//	here i make the method to save the data 
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
//	here i create the method for reterieving the particular user 
	public User findOne(int id) {
//		here i use the functional programming to fetch the details of the particular user
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
//		return users.stream().filter(predicate).findFirst().get();
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
//	here i wite the method for deleting the user 
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		users.removeIf(predicate);
		
	}
}
