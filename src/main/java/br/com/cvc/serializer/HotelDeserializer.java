package br.com.cvc.serializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.com.cvc.dto.CityDTO;
import br.com.cvc.dto.HotelDTO;
import br.com.cvc.dto.RoomDTO;

@JsonComponent
public class HotelDeserializer extends JsonDeserializer<HotelDTO> {
	@Override
	public HotelDTO deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {

		JsonNode node = parser.getCodec().readTree(parser);
		Long id = (Long) node.get("id").asLong();
		String name = node.get("name").asText();
		
		Long cityCode = node.get("cityCode").asLong();
		String cityName = node.get("cityName").asText();
		CityDTO city = CityDTO.of(cityCode, cityName);
		
		Iterator<JsonNode> rooms = node.get("rooms").elements();
		List<RoomDTO> listRooms = new ArrayList<RoomDTO>();
		rooms.forEachRemaining(lr -> listRooms.add(convertRoom(lr)));
		
		HotelDTO hotel = new HotelDTO();
		hotel.setId(id);
		hotel.setName(name);
		hotel.setCity(city);
		hotel.setRooms(listRooms);
		
		return hotel;
	}

	private RoomDTO convertRoom(JsonNode node) {
		Long roomID = node.get("roomID").asLong();
		String categoryName = node.get("categoryName").asText();
	
		JsonNode priceNode = node.get("price");
		BigDecimal adult = priceNode.get("adult").decimalValue();
		BigDecimal child = priceNode.get("child").decimalValue();
		
		return RoomDTO.of(roomID, categoryName, adult, child);
		
	}

}
