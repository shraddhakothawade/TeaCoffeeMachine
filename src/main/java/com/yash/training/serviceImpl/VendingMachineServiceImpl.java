package com.yash.training.serviceImpl;

import java.util.logging.Logger;

import com.yash.training.TeaCoffeeMachine.VendingMachineSale;
import com.yash.training.model.ContainerDTO;
import com.yash.training.model.DrinkIngredientsDTO;
import com.yash.training.model.DrinkType;
import com.yash.training.service.Container;
import com.yash.training.service.VendingMachineService;

public class VendingMachineServiceImpl extends VendingMachineSale implements VendingMachineService, Container {

	private Integer totalWasteInml = 0;
	private Integer totalWasteIngm = 0;
	private Integer refillCounter = 0;

	private DrinkIngredientsDTO drinkIngredients;
	private ContainerDTO drinkIngredientsAvailableInContainer;
	private DrinkIngredientsDTO teaIngredients;
	private DrinkIngredientsDTO coffeeIngredients;
	private DrinkIngredientsDTO blackTeaIngredients;
	private DrinkIngredientsDTO blackCoffeeIngredients;

	Logger LOGGER = Logger.getLogger(VendingMachineServiceImpl.class.getName());

	public VendingMachineServiceImpl() {

		System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s%6$s%n\u001B[30m");

		drinkIngredientsAvailableInContainer = new ContainerDTO(2000, 2000, 15000, 10000, 8000);
		teaIngredients = new DrinkIngredientsDTO(6, 0, 65, 44, 17, 1, 0, 5, 4, 2);
		coffeeIngredients = new DrinkIngredientsDTO(0, 5, 23, 88, 17, 0, 1, 3, 8, 2);
		blackTeaIngredients = new DrinkIngredientsDTO(3, 0, 112, 0, 17, 0, 0, 12, 0, 2);
		blackCoffeeIngredients = new DrinkIngredientsDTO(0, 3, 65, 44, 17, 0, 0, 12, 0, 2);

	}

	@Override
	public Integer prepareDrink(DrinkType drink, Integer noOfCups) {

		int totalCostOfDrink = 0;

		switch (drink) {
		case BLACK_COFFEE:
			drinkIngredients = blackCoffeeIngredients;
			totalCostOfDrink = noOfCups * costOfBlackCoffee;
			break;
		case BLACK_TEA:
			drinkIngredients = blackTeaIngredients;
			totalCostOfDrink = noOfCups * costOfBlackTea;
			break;
		case COFFEE:
			drinkIngredients = coffeeIngredients;
			totalCostOfDrink = noOfCups * costOfCoffee;
			break;
		case TEA:
			drinkIngredients = teaIngredients;
			totalCostOfDrink = noOfCups * costOfTea;
			break;

		}

		if (!checkIngredientsAvailability(drinkIngredients, noOfCups))
			return 0;
		else {
			calculateWasteMaterial(drinkIngredients, noOfCups);
			addTotalCostToSaleRecord(drink, noOfCups, totalCostOfDrink);
			return totalCostOfDrink;
		}

	}

	private Boolean checkIngredientsAvailability(DrinkIngredientsDTO drinkIngredients, int noOfCups) {

		Integer availableTeaQuantity = drinkIngredientsAvailableInContainer.getTeaQuantity()
				- noOfCups * drinkIngredients.getTeaQuantity();
		Integer availableCoffeeQuantity = drinkIngredientsAvailableInContainer.getCoffeeQuantity()
				- noOfCups * drinkIngredients.getCoffeeQuantity();
		Integer availableWaterQuantity = drinkIngredientsAvailableInContainer.getWaterQuantity()
				- noOfCups * drinkIngredients.getWaterQuantity();
		Integer availableMilkQuantity = drinkIngredientsAvailableInContainer.getMilkQuantity()
				- noOfCups * drinkIngredients.getMilkQuantity();
		Integer availableSugarQuantity = drinkIngredientsAvailableInContainer.getSugarQuantity()
				- noOfCups * drinkIngredients.getSugarQuantity();

		if (availableTeaQuantity <= 0 || availableCoffeeQuantity <= 0) {
			LOGGER.warning("Not enough Tea or Coffee");
		} else if (availableSugarQuantity < 0) {
			LOGGER.warning("Not enough Sugar");
		} else if (availableMilkQuantity < 0) {
			LOGGER.warning("Not enough Milk");
		} else if (availableWaterQuantity < 0) {
			LOGGER.warning("Not enough Water");
		} else {
			updateContainer(drinkIngredientsAvailableInContainer, availableTeaQuantity, availableCoffeeQuantity,
					availableWaterQuantity, availableMilkQuantity, availableSugarQuantity);

			return true;
		}
		return false;

	}

	private void calculateWasteMaterial(DrinkIngredientsDTO drinkIngredients, int noOfCups) {

		totalWasteIngm += noOfCups * (drinkIngredients.getCoffeeWastage() + +drinkIngredients.getTeaWastage()
				+ drinkIngredients.getSugarWastage());

		totalWasteInml += noOfCups * (drinkIngredients.getMilkWastage() + drinkIngredients.getWaterWastage());
	}

	@Override
	public void showContainerStatus() {

		LOGGER.info("*******Current Status of Container*******");
		LOGGER.info("Container\tCapacity");
		LOGGER.info(drinkIngredientsAvailableInContainer.toString());
		LOGGER.info("Container refill is done :" + refillCounter + "  times");
		LOGGER.info("Total Wastage :\t" + totalWasteIngm + " gm " + totalWasteInml + " ml\n");
	}

	@Override
	public void resetContainer() {

		updateContainer(drinkIngredientsAvailableInContainer, 2000, 2000, 15000, 10000, 8000);
		LOGGER.info("Container reset is done successfully...");
	}

	@Override
	public void refillContainer(Integer teaQuantity, Integer coffeeQuantity, Integer waterQuantity,
			Integer milkQuantity, Integer sugarQuantity) {

		Boolean refillStatus = false;

		if (teaQuantity <= 2000 - drinkIngredientsAvailableInContainer.getTeaQuantity()) {
			refillStatus = true;
			drinkIngredientsAvailableInContainer.setTeaQuantity(teaQuantity);
		} else
			LOGGER.warning("Overflow tea quantity...");

		if (coffeeQuantity <= 2000 - drinkIngredientsAvailableInContainer.getCoffeeQuantity()) {
			refillStatus = true;
			drinkIngredientsAvailableInContainer.setTeaQuantity(coffeeQuantity);
		} else
			LOGGER.warning("Overflow coffee quantity...");

		if (waterQuantity <= 15000 - drinkIngredientsAvailableInContainer.getWaterQuantity()) {
			refillStatus = true;
			drinkIngredientsAvailableInContainer.setTeaQuantity(waterQuantity);
		} else
			LOGGER.warning("Overflow water quantity...");

		if (milkQuantity <= 10000 - drinkIngredientsAvailableInContainer.getMilkQuantity()) {
			refillStatus = true;
			drinkIngredientsAvailableInContainer.setTeaQuantity(milkQuantity);
		} else
			LOGGER.warning("Overflow milk quantity...");

		if (sugarQuantity <= 8000 - drinkIngredientsAvailableInContainer.getSugarQuantity()) {
			refillStatus = true;
			drinkIngredientsAvailableInContainer.setTeaQuantity(sugarQuantity);
		} else
			LOGGER.warning("Overflow sugar quantity...");

		if (refillStatus == true)
			refillCounter += 1;

	}
	

}
