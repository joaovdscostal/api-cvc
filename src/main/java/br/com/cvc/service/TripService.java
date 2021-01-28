package br.com.cvc.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.cvc.controller.form.TravelInformationForm;
import br.com.cvc.dto.CityDTO;
import br.com.cvc.dto.HotelDTO;
import br.com.cvc.dto.RoomDTO;
import br.com.cvc.model.Trip;
import br.com.cvc.model.TripRoom;

@Service
public class TripService {
	
	@Value("${comission}")
	private BigDecimal comission;
	
	public List<Trip> getTripFrom(List<HotelDTO> hotels, TravelInformationForm form) {
		CityDTO city = hotels.get(0).getCity();
		List<Trip> tripList = new ArrayList<Trip>();
		
		for (HotelDTO hotel : hotels) {
			Trip trip = new Trip();
			trip.setId(hotel.getId());
			trip.setCityName(city.getCityName());
			
			for (RoomDTO room : hotel.getRooms()) {
				TripRoom tripRoom = TripRoom.of(form, room, comission);
				trip.add(tripRoom);
			}
			
			tripList.add(trip);
		}
		
		return tripList;
	}
	
}
