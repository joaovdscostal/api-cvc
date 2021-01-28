package br.com.cvc.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.cvc.serializer.HotelDeserializer;

@JsonDeserialize(using = HotelDeserializer.class)
public class HotelDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private CityDTO city;
	private List<RoomDTO> rooms;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CityDTO getCity() {
		return city;
	}

	public void setCity(CityDTO city) {
		this.city = city;
	}

	public List<RoomDTO> getRooms() {
		return rooms;
	}

	public void setRooms(List<RoomDTO> rooms) {
		this.rooms = rooms;
	}

	public static HotelDTO of(Long hotelID) {
		HotelDTO hotelDTO = new HotelDTO();
		hotelDTO.setId(hotelID);
		return hotelDTO;
	}

}
