package com.yash.training.model;

public enum DrinkType {
	TEA("Tea"), COFFEE("Coffee"), BLACK_TEA("BlackTea"), BLACK_COFFEE("BlackCoffee");

	private final String textValue;

	DrinkType(final String textValue) {
		this.textValue = textValue;
	}

	@Override
	public String toString() {
		return textValue;
	}
}
