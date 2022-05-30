package com.example.HotelReservation.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Room_Table")

public class Room {
      @Id
      @GeneratedValue(strategy=GenerationType.AUTO)
      private long roomId;
      @Column
      private int hotelno;
      @Column
      private String room_type;
      @Column
      private int days;
      @Column
      private int price;
      @Temporal(TemporalType.TIMESTAMP)
	  private Date checkinDate;
      @Temporal(TemporalType.TIMESTAMP)
	  private Date checkOutDate;

	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnoreProperties("room")
	private User user;
  /*  @PrePersist
public void InsertcheckinDate()
{
	this.checkinDate=new Date();
	this.price=days*500;
}*/

  

public long getRoomId() {
	return roomId;
}

public void setRoomId(long roomId) {
	this.roomId = roomId;
}

public int getHotelno() {
	return hotelno;
}

public void setHotelno(int hotelno) {
	this.hotelno = hotelno;
}

public String getRoom_type() {
	return room_type;
}

public void setRoom_type(String room_type) {
	this.room_type = room_type;
}

public int getDays() {
	return days;
}

public void setDays(int days) {
	this.days = days;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public Date getCheckinDate() {
	return checkinDate;
}

public void setCheckinDate(Date checkinDate) {
	this.checkinDate = checkinDate;
}

public Date getCheckOutDate() {
	return checkOutDate;
}

public void setCheckOutDate(Date checkOutDate) {
	this.checkOutDate = checkOutDate;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

@Override
public String toString() {
	return "Room [roomId=" + roomId + ", hotelno=" + hotelno + ", room_type=" + room_type + ", days=" + days
			+ ", price=" + price + ", checkinDate=" + checkinDate + ", checkOutDate=" + checkOutDate + ", user=" + user
			+ "]";
}

public Room(long roomId, int hotelno, String room_type, int days, int price, Date checkinDate, Date checkOutDate,
		User user) {
	super();
	this.roomId = roomId;
	this.hotelno = hotelno;
	this.room_type = room_type;
	this.days = days;
	this.price = price;
	this.checkinDate = checkinDate;
	this.checkOutDate = checkOutDate;
	this.user = user;
}

public Room() {
	super();

}

}