package com.example.HotelReservation.Service;

import com.example.HotelReservation.entity.Room;

public interface RoomService {

	Room saveRoom(Room reserve);

	Room updateRoom(Long id, Room reserve);

}
