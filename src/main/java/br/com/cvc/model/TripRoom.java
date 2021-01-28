package br.com.cvc.model;

import java.math.BigDecimal;

import br.com.cvc.controller.form.TravelInformationForm;
import br.com.cvc.dto.RoomDTO;
import br.com.cvc.utils.MoneyUtils;

public class TripRoom {
	private Long roomID;
	private String categoryName;
	private BigDecimal totalPrice;
	private TripRoomPrice priceDetail;


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

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public TripRoomPrice getPriceDetail() {
		return priceDetail;
	}

	public void setPriceDetail(TripRoomPrice priceDetail) {
		this.priceDetail = priceDetail;
	}

	public static TripRoom of(TravelInformationForm form, RoomDTO room, BigDecimal comission) {
		TripRoom tripRoom = new TripRoom();
		tripRoom.setCategoryName(room.getCategoryName());
		tripRoom.setRoomID(room.getRoomID());
		
		BigDecimal valueUnitByAdult = room.getPrice().getAdult();
		BigDecimal valueUnitByChild = room.getPrice().getChild();
		
		BigDecimal valuePerDayByAdultWithComission = MoneyUtils.applyComission(valueUnitByAdult, comission);
		BigDecimal valuePerDayByChildWithComission = MoneyUtils.applyComission(valueUnitByChild, comission);
		
		BigDecimal valueTotalByAdult = MoneyUtils.multiply(valuePerDayByAdultWithComission, form.getTotalAdults());
		BigDecimal valueTotalByChild = MoneyUtils.multiply(valuePerDayByChildWithComission, form.getTotalChildren());
		
		Integer travelDays = form.getTravelDays();

		BigDecimal totalPrice = valueTotalByAdult.add(valueTotalByChild);
		totalPrice = MoneyUtils.multiply(totalPrice, travelDays);
		
		TripRoomPrice price = TripRoomPrice.of(valuePerDayByAdultWithComission, valuePerDayByChildWithComission);
		tripRoom.setPriceDetail(price);
		tripRoom.setTotalPrice(totalPrice);

		return tripRoom;
	}

}

