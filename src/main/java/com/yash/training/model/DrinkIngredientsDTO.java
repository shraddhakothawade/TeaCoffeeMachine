package com.yash.training.model;

public class DrinkIngredientsDTO {
	private Integer teaQuantity;
	private Integer coffeeQuantity;
	private Integer waterQuantity;
	private Integer milkQuantity;
	private Integer sugarQuantity;
	private Integer teaWastage;
	private Integer coffeeWastage;
	private Integer waterWastage;
	private Integer milkWastage;
	private Integer sugarWastage;

	public DrinkIngredientsDTO(Integer teaQuantity, Integer coffeeQuantity, Integer waterQuantity, Integer milkQuantity,
			Integer sugarQuantity, Integer teaWastage, Integer coffeeWastage, Integer waterWastage, Integer milkWastage,
			Integer sugarWastage) {

		this.teaQuantity = teaQuantity;
		this.coffeeQuantity = coffeeQuantity;
		this.waterQuantity = waterQuantity;
		this.milkQuantity = milkQuantity;
		this.sugarQuantity = sugarQuantity;
		this.teaWastage = teaWastage;
		this.coffeeWastage = coffeeWastage;
		this.waterWastage = waterWastage;
		this.milkWastage = milkWastage;
		this.sugarWastage = sugarWastage;
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

	public Integer getTeaWastage() {
		return teaWastage;
	}

	public Integer getCoffeeWastage() {
		return coffeeWastage;
	}

	public Integer getWaterWastage() {
		return waterWastage;
	}

	public Integer getMilkWastage() {
		return milkWastage;
	}

	public Integer getSugarWastage() {
		return sugarWastage;
	}

}
