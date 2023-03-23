package model;

public class Car {
	private String number;
	private String model;
	private int price;
	private String brand;

	public Car(String number, String model, int price, String brand) {
		super();
		this.number = number;
		this.model = model;
		this.price = price;
		this.brand = brand;
	}

	public Car() {
		super();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Car [number=" + number + ", model=" + model + ", price=" + price + ", brand=" + brand + "]";
	}

}
