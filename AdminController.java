package com.example.HotelReservation.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HotelReservation.Service.UserService;
import com.example.HotelReservation.entity.User;

@RestController
@RequestMapping("/api/user_admin")
public class AdminController
{

	UserService userservice;

	public AdminController(UserService userservice) {
		super();
		this.userservice = userservice;
	}

	@GetMapping
	public  List<User> listAllUser() {
		
		return userservice.listAllUser();
		
	}
	
	

	@DeleteMapping("{id}")

	public String deleteUser(@PathVariable("id") long id){
		userservice.deleteUser(id);
		return ("User record deleted ");
		
	}

	

	
	@GetMapping("/getUserByUsername/{username}")
	public List<User>getUserByUsername(@PathVariable("username")String username)
	{
		return userservice.getUserByUsername(username);
	}
	
	
}

