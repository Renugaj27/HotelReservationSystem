package com.example.HotelReservation.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HotelReservation.entity.Room;

public interface RoomRepository extends JpaRepository <Room, Long>{

	
}
