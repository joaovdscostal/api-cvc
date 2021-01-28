package br.com.cvc.model;

import java.math.BigDecimal;

public class TripRoomPrice {

	private BigDecimal pricePerDayAdult;
	private BigDecimal pricePerDayChild;

	public BigDecimal getPricePerDayAdult() {
		return pricePerDayAdult;
	}

	public void setPricePerDayAdult(BigDecimal pricePerDayAdult) {
		this.pricePerDayAdult = pricePerDayAdult;
	}

	public BigDecimal getPricePerDayChild() {
		return pricePerDayChild;
	}

	public void setPricePerDayChild(BigDecimal pricePerDayChild) {
		this.pricePerDayChild = pricePerDayChild;
	}

	public static TripRoomPrice of(BigDecimal valueTotalByAdultWithComission, BigDecimal valueTotalByChildWithComission) {
		TripRoomPrice price = new TripRoomPrice();
		price.setPricePerDayAdult(valueTotalByAdultWithComission);
		price.setPricePerDayChild(valueTotalByChildWithComission);
		return price;
	}

}