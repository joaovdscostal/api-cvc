package br.com.cvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvc.controller.form.TravelInformationForm;
import br.com.cvc.dto.CityDTO;
import br.com.cvc.dto.HotelDTO;
import br.com.cvc.model.Trip;
import br.com.cvc.service.TripService;
import br.com.cvc.service.ApiHotelService;


@RestController
@RequestMapping("/trip")
public class ApiController {
	
	@Autowired
	private ApiHotelService apiHotel;
	
	@Autowired
	private TripService tripService;
	
	
	@GetMapping("/city/{cityCode}")
	@Cacheable(value = "trips")
	public ResponseEntity<List<Trip>> getTripsByCity(@PathVariable Long cityCode, @Valid TravelInformationForm form){
		List<HotelDTO> hotels = apiHotel.findAllHotelsByCity(CityDTO.of(cityCode));
		List<Trip> trips = tripService.getTripFrom(hotels, form);
		
		if(trips.isEmpty())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(trips);
	}
	
	@GetMapping("/hotel/{hotelID}")
	@Cacheable(value = "tripsByHotel")
	public ResponseEntity<List<Trip>> getTripsByHotel(@PathVariable Long hotelID, @Valid TravelInformationForm form){
		List<HotelDTO> hotels = apiHotel.findAllHotelsByHotel(HotelDTO.of(hotelID));
		List<Trip> trips = tripService.getTripFrom(hotels, form);
		
		if(trips.isEmpty())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(trips);
	}
	
	
	
	
}