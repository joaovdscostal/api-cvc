package br.com.cvc.dto;

public class CityDTO {
	
	private Long cityCode;
	private String cityName;
	
	public Long getCityCode() {
		return cityCode;
	}
	public void setCityCode(Long cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public static CityDTO of(Long codeCity) {
		return of(codeCity, null);
	}
	public static CityDTO of(Long cityCode2, String cityName2) {
		CityDTO city = new CityDTO();
		city.setCityCode(cityCode2);
		city.setCityName(cityName2);
		return city;
	}

	
	
}
