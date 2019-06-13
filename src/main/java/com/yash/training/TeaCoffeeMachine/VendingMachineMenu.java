package com.yash.training.TeaCoffeeMachine;

import java.util.logging.Logger;

import com.yash.training.model.DrinkType;
import com.yash.training.serviceImpl.VendingMachineServiceImpl;
import com.yash.training.util.IntegerScanner;

public class VendingMachineMenu {

	Logger LOGGER = Logger.getLogger(VendingMachineServiceImpl.class.getName());

	VendingMachineServiceImpl vendingMachineService = new VendingMachineServiceImpl();
	IntegerScanner scanner = new IntegerScanner();

	public VendingMachineMenu() {
		System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s%6$s%n\u001B[30m");
	}

	public void vendingMachineMenuList(Boolean IsContinue) {

		Integer choice, noOfCups, totalCostOfDrink, teaQuantity, coffeeQuantity, sugarQuantity, waterQuantity,
				milkQuantity;

		LOGGER.info(
				"*********Menu********\n1. Coffe\n2. Tea\n3. BlackTea\n4. BlackCoffe\n5. Container Status\n6. Reset Container\n7. Refill Container\n8. Check total sale\n");
		do {
			LOGGER.info("Enter your Selection :");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				LOGGER.info("Enter no of cups of Drink");
				noOfCups = scanner.nextInt();

				totalCostOfDrink = vendingMachineService.prepareDrink(DrinkType.COFFEE, noOfCups);
				LOGGER.info("Your drink is ready....\nTotal cost of Drink :" + totalCostOfDrink + "\n");
				break;
			case 2:
				LOGGER.info("Enter no of cups of Drink");
				noOfCups = scanner.nextInt();

				totalCostOfDrink = vendingMachineService.prepareDrink(DrinkType.TEA, noOfCups);
				LOGGER.info("Your drink is ready....\nTotal cost of Drink :" + totalCostOfDrink + "\n");
				break;
			case 3:
				LOGGER.info("Enter no of cups of Drink");
				noOfCups = scanner.nextInt();

				totalCostOfDrink = vendingMachineService.prepareDrink(DrinkType.BLACK_TEA, noOfCups);
				LOGGER.info("Your drink is ready....\nTotal cost of Drink :" + totalCostOfDrink + "\n");
				break;
			case 4:
				LOGGER.info("Enter no of cups of Drink");
				noOfCups = scanner.nextInt();

				totalCostOfDrink = vendingMachineService.prepareDrink(DrinkType.BLACK_COFFEE, noOfCups);
				LOGGER.info("Your drink is ready....\nTotal cost of Drink :" + totalCostOfDrink + "\n");
				break;
			case 5:
				vendingMachineService.showContainerStatus();
				break;
			case 6:
				vendingMachineService.resetContainer();
				break;
			case 7:
				LOGGER.info("Please enter the tea quantity");
				teaQuantity = scanner.nextInt();
				LOGGER.info("Please enter the coffee quantity");
				coffeeQuantity = scanner.nextInt();
				LOGGER.info("Please enter the water quantity");
				waterQuantity = scanner.nextInt();
				LOGGER.info("Please enter the milk quantity");
				milkQuantity = scanner.nextInt();
				LOGGER.info("Please enter the sugar quantity");
				sugarQuantity = scanner.nextInt();
				vendingMachineService.refillContainer(teaQuantity, coffeeQuantity, waterQuantity, milkQuantity,
						sugarQuantity);
				break;

			case 8:
				vendingMachineService.generateTotalSaleReport();
				vendingMachineService.generateDrinkwiseSaleReport();

				break;
			case 9:
				IsContinue = false;
				System.out.println("Exit");
				break;
			default:
				LOGGER.warning("Invalid selection....\n");

			}
		} while (IsContinue);

	}
}
