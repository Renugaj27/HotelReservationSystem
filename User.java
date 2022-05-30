package com.example.HotelReservation.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="user_table")
//@Data
//@EqualsAndHashCode(exclude="room")
public class User {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long userId;
	@Column
    private String username;
	@Column
    private String email;
	@Column
    private long phoneno;
	@Column
    private String  location;
	
	@OneToMany
	@JsonIgnoreProperties("user")
	@JoinTable(name="Reservation",joinColumns= {@JoinColumn(name="userId")},inverseJoinColumns=@JoinColumn(name="roomId"))
	private List<Room> room;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Room> getRoom() {
		return room;
	}
	public void setRoom(List<Room> room) {
		this.room = room;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", phoneno=" + phoneno
				+ ", location=" + location
				+ ", room=" + room + "]";
	}
	public User(long userId, String username, String email, long phoneno, String location, 
		List<Room> room) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.phoneno = phoneno;
		this.location = location;
		this.room = room;
	}
	public User() {
		super();
	
	}
}
