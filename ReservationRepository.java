package com.example.HotelReservation.Repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HotelReservation.entity.User;

public interface ReservationRepository extends  JpaRepository<User,Long>{

	

	List<User> getUserByUsername(String username);

	Optional<User> findByEmail(String email);


}
