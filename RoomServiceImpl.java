package com.example.HotelReservation.Service;

import org.springframework.stereotype.Service;

import com.example.HotelReservation.exception.ResourceNotFoundException;
import com.example.HotelReservation.Repository.RoomRepository;
import com.example.HotelReservation.entity.Room;



@Service
public class RoomServiceImpl implements RoomService {

	RoomRepository reservationRepository;
	
	
	public RoomServiceImpl(RoomRepository reservationRepository) {
		super();
		this.reservationRepository= reservationRepository;
	}

	@Override
	public Room saveRoom(Room reserve) {
		return reservationRepository.save(reserve);
	}

	@Override
	public Room updateRoom(Long id, Room reserve) {
		Room rm=new Room();
		try {
			rm=reservationRepository.findById(id).orElseThrow(
					()->   new ResourceNotFoundException("Room","Id",id));
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// String fname=reserve.getRoom_type();
		rm.setHotelno(reserve.getHotelno());
		rm.setRoomId(reserve.getRoomId());
		rm.setDays(reserve.getDays());
		rm.setRoom_type(reserve.getRoom_type());
		rm.setPrice(reserve.getPrice());
		rm.setCheckinDate(reserve.getCheckinDate());
		rm.setCheckOutDate(reserve.getCheckOutDate());
		reservationRepository.save(rm);
		return rm;
	}}

	