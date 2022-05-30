package com.example.HotelReservation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HotelReservation.entity.User;

public interface AdminRepository extends JpaRepository<User,Long>{

	List<User> getUserByUsername(String username);

	
}