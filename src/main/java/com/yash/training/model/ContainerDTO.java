package com.yash.training.model;

public class ContainerDTO {
	private Integer teaQuantity;	
	private Integer coffeeQuantity;
	private Integer waterQuantity;
	private Integer milkQuantity;
	private Integer sugarQuantity;
	
	public ContainerDTO(Integer teaQuantity, Integer coffeeQuantity, Integer waterQuantity, Integer milkQuantity,
			Integer sugarQuantity) {
		
		this.teaQuantity = teaQuantity;
		this.coffeeQuantity = coffeeQuantity;
		this.waterQuantity = waterQuantity;
		this.milkQuantity = milkQuantity;
		this.sugarQuantity = sugarQuantity;
	}

	public Integer getTeaQuantity() {
		return teaQuantity;
	}

	public Integer getCoffeeQuantity() {
		return coffeeQuantity;
	}

	public Integer getWaterQuantity() {
		return waterQuantity;
	}

	public Integer getMilkQuantity() {
		return milkQuantity;
	}

	public Integer getSugarQuantity() {
		return sugarQuantity;
	}

	public void setTeaQuantity(Integer teaQuantity) {
		this.teaQuantity = teaQuantity;
	}

	public void setCoffeeQuantity(Integer coffeeQuantity) {
		this.coffeeQuantity = coffeeQuantity;
	}

	public void setWaterQuantity(Integer waterQuantity) {
		this.waterQuantity = waterQuantity;
	}

	public void setMilkQuantity(Integer milkQuantity) {
		this.milkQuantity = milkQuantity;
	}

	public void setSugarQuantity(Integer sugarQuantity) {
		this.sugarQuantity = sugarQuantity;
	}
	
	@Override
	public String toString() {
		return ("Tea :  " + teaQuantity + "\nCoffee:  " + coffeeQuantity + "\nMilk:  " + milkQuantity + "\nSugar:  "
				+ sugarQuantity + "\nWater:  " + waterQuantity);
	}
	
}
