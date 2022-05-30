package com.example.HotelReservation.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.HotelReservation.exception.ResourceNotFoundException;
import com.example.HotelReservation.Repository.ReservationRepository;
import com.example.HotelReservation.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	ReservationRepository reservationRepository;
	

	public UserServiceImpl(ReservationRepository reservationRepository) {
		super();
		this.reservationRepository = reservationRepository;
	}

	@Override
	public List<User> listAllUser() {
		return reservationRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return reservationRepository.save(user);
	}

	@Override
	public User updateUser(Long id, User user) {
		User us = new User();
		try {
			//orElseThrow();
			us = reservationRepository.findById(id).orElseThrow(
					()->  new com.example.HotelReservation.exception.ResourceNotFoundException("User","Id",id));
		}catch (Exception e)
		{
			e.printStackTrace();
			
		}
		
		String fname=user.getUsername();
		us.setUsername(fname);
		us.setPhoneno(user.getPhoneno());
		us.setEmail(user.getEmail());
		us.setLocation(user.getLocation());
		
		reservationRepository.save(user);
		return us;
	}

	@Override
	public List<User> getUserByUsername(String username) {
		return reservationRepository.getUserByUsername(username);
	}

	@Override
	public void deleteUser(long id)
	{
	reservationRepository.findById(id).orElseThrow(
			()-> new ResourceNotFoundException("User","Id",id));
	
	reservationRepository.deleteById(id);
		
	}

}



	


