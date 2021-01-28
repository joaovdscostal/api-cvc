package br.com.cvc.controller.form;

import java.time.LocalDate;
import java.time.Period;

import javax.validation.constraints.NotNull;

public class TravelInformationForm {
	
	@NotNull
	private LocalDate checkin; 
	
	@NotNull
	private LocalDate checkout;

	@NotNull
	private Integer totalAdults;

	@NotNull
	private Integer totalChildren;
	
	public LocalDate getCheckin() {
		return checkin;
	}

	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	public void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
	}

	public Integer getTotalAdults() {
		return totalAdults;
	}

	public void setTotalAdults(Integer totalAdults) {
		this.totalAdults = totalAdults;
	}

	public Integer getTotalChildren() {
		return totalChildren;
	}

	public void setTotalChildren(Integer totalChildren) {
		this.totalChildren = totalChildren;
	}

	public Integer getTravelDays() {
		Period period = Period.between(this.checkin, this.checkout);
		
		Integer days = period.getDays();
		
		if(days < 0)
			return 0;
		
		return days;
	}
	
	
}
	
