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

import com.example.HotelReservation.Service.RoomService;
import com.example.HotelReservation.entity.Room;

@RestController
@RequestMapping("/api/room")
public class RoomController {
	

	 RoomService reservationservice;

	

	public RoomController(RoomService reservationservice) {
		super();
		this.reservationservice = reservationservice;
	}




	/*@GetMapping
	public List<Reservation> listAllReservation()
	{
		return reservationservice.listAllReservation();
	
	}*/




	@PostMapping
	public ResponseEntity<Room> saveRoom(@RequestBody Room reserve){
			
			 return new ResponseEntity<Room>(reservationservice.saveRoom(reserve), HttpStatus.CREATED);
		
		} 


	@PutMapping("{id}")
	public ResponseEntity<Room> updateRoom(@PathVariable("id") Long id , @RequestBody Room reserve) {
		return new ResponseEntity<Room>(reservationservice.updateRoom( id,  reserve), HttpStatus.OK);
		
	}

}
