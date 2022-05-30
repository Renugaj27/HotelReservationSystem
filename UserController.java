package com.example.HotelReservation.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HotelReservation.Service.UserService;
import com.example.HotelReservation.entity.User;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	UserService userService ;
		 
		public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

		
		@GetMapping
		public List<User> listAllUser()
		{
			return userService.listAllUser();
			
			
		}


		@PostMapping
		public ResponseEntity<User> saveUser(@RequestBody User user){
				 return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
			
			} 
		

		@PutMapping("{id}")
		public ResponseEntity<User> updateUser(@PathVariable("id") Long id , @RequestBody User user) {
			return new ResponseEntity<User>(userService.updateUser( id,  user), HttpStatus.OK);
			
		}
		
		
		
		

}
