package com.ssafy.report;

public class CountryDTO {
	private String code;
	private String name;
	private String continent;
	private double lifeExpectancy;
	public CountryDTO(String code, String name, String continent, double lifeExpectancy) {
		super();
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.lifeExpectancy = lifeExpectancy;
	}
	public CountryDTO() {
		super();
	}
	@Override
	public String toString() {
		return "CountryDTO [code=" + code + ", name=" + name + ", continent=" + continent + ", lifeExpectancy="
				+ lifeExpectancy + "]";
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public double getLifeExpectancy() {
		return lifeExpectancy;
	}
	public void setLifeExpectancy(double lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}
	
	
}
