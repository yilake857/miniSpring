package org.springframework.test.bean;

import org.github.springframework.context.annotation.Value;
import org.github.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Car {

	private int price;

	private LocalDate produceDate;


	@Value("${brand}")
	private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getProduceDate() {
		return produceDate;
	}

	public void setProduceDate(LocalDate produceDate) {
		this.produceDate = produceDate;
	}

	@Override
	public String toString() {
		return "Car{" +
				"price=" + price +
				", produceDate=" + produceDate +
				", brand='" + brand + '\'' +
				'}';
	}
}