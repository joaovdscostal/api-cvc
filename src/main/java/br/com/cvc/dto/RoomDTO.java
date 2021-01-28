package br.com.cvc.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class RoomDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long roomID;
	private String categoryName;
	private PriceDTO price;

	public Long getRoomID() {
		return roomID;
	}

	public void setRoomID(Long roomID) {
		this.roomID = roomID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public PriceDTO getPrice() {
		return price;
	}

	public void setPrice(PriceDTO price) {
		this.price = price;
	}

	public static RoomDTO of(Long roomID, String categoryName, BigDecimal adult, BigDecimal child) {
		RoomDTO room = new RoomDTO();
		room.setRoomID(roomID);
		room.setCategoryName(categoryName);
		
		PriceDTO price = PriceDTO.of(adult, child);
		room.setPrice(price);
		return room;
	}

}