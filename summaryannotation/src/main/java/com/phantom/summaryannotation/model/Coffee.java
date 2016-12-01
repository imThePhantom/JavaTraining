package com.phantom.summaryannotation.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Coffees")
public class Coffee {
	private Long coffeeId;
	private String coffeeCode;
	private String name;
	private BigDecimal price;
	private boolean enabled;

	public Coffee() {
	}

	public Coffee(Long coffeeId, String coffeeCode, String name, BigDecimal price) {
		this.coffeeId = coffeeId;
		this.coffeeCode = coffeeCode;
		this.name = name;
		this.price = price;
	}

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "coffe_id")
	public Long getCoffeeId() {
		return coffeeId;
	}

	public void setCoffeeId(Long coffeeId) {
		this.coffeeId = coffeeId;
	}

	@Column(name = "coffee_code", nullable = false, unique = true)
	public String getCoffeeCode() {
		return coffeeCode;
	}

	public void setCoffeeCode(String coffeeCode) {
		this.coffeeCode = coffeeCode;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price", nullable = false)
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "enabled", nullable = false, columnDefinition = "boolean default true")
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String toString() {
		return "Coffee: " + name + ", Code: " + coffeeCode + ", price: " + price
				+ (isEnabled() ? ", available now" : "not available");
	}
}
