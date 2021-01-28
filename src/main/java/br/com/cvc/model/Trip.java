package br.com.cvc.model;

import java.util.ArrayList;
import java.util.List;

public class Trip {
	private Long id;
	private String cityName;
	private List<TripRoom> rooms;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<TripRoom> getRooms() {
		if(rooms == null) {
			rooms = new ArrayList<>();
		}
		return rooms;
	}

	public void setRooms(List<TripRoom> rooms) {
		this.rooms = rooms;
	}

	public void add(TripRoom tripRoom) {
		getRooms().add(tripRoom);
	}

}
