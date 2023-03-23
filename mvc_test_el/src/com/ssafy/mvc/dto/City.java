package com.ssafy.mvc.dto;

public class City {
	private int id;
	private String name;
	private String contryCode;
	private int population;
	
	public City() {
		super();
	}
	
	public City(int id, String name, String contryCode, int population) {
		this.id = id;
		this.name = name;
		this.contryCode = contryCode;
		this.population = population;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContryCode() {
		return contryCode;
	}
	public void setContryCode(String contryCode) {
		this.contryCode = contryCode;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", contryCode=" + contryCode + ", population=" + population + "]";
	}
	
	
	
}
