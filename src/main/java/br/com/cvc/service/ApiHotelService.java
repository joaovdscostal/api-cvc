package br.com.cvc.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.cvc.dto.CityDTO;
import br.com.cvc.dto.HotelDTO;

@Service
public class ApiHotelService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${resource.url.city}")
	private String urlHotelByCity;
	
	@Value("${resource.url.hotel}")
	private String urlHotelByHotel;
	
	
	public List<HotelDTO> findAllHotelsByCity(CityDTO city) {
		return Arrays.stream(restTemplate.getForObject(urlHotelByCity, HotelDTO[].class, city.getCityCode())).collect(Collectors.toList());
	}

	public List<HotelDTO> findAllHotelsByHotel(HotelDTO hotel) {
		return Arrays.stream(restTemplate.getForObject(urlHotelByHotel, HotelDTO[].class, hotel.getId())).collect(Collectors.toList());
	}

	
	
	/*public List<AvailHotelDto> findAllAvailHotelsBys(@Valid TravelInformationForm form) {
		String urlWithCodeHotel = urlByCity + form.getCityCode();
		return Arrays.stream(restTemplate.getForObject(urlWithCodeHotel, AvailHotelDto[].class)).collect(Collectors.toList());
	}*/
	
}
