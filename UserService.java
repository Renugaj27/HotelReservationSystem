package com.example.HotelReservation.Service;

import java.util.List;

import com.example.HotelReservation.entity.User;

public interface UserService {

	List<User> listAllUser();
	User saveUser(User user);
    User updateUser(Long id, User user);
	void deleteUser(long id);
	List<User> getUserByUsername(String username);

	


}

