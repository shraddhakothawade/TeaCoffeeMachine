package com.yash.training.service;

import com.yash.training.model.DrinkType;



public interface VendingMachineService {
	Integer costOfTea = 10;
	Integer costOfCoffee = 15;
	Integer costOfBlackTea = 5;
	Integer costOfBlackCoffee = 10;
	
	Integer prepareDrink(DrinkType drink, Integer noOfCups);
}
