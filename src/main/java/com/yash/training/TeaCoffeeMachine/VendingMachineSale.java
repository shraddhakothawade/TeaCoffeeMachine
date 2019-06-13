package com.yash.training.TeaCoffeeMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.yash.training.model.DrinkType;

public class VendingMachineSale {

	private Map<DrinkType, int[]> totalSaleRecord = new HashMap<DrinkType, int[]>();
	Logger LOGGER = Logger.getLogger(VendingMachineSale.class.getName());

	public VendingMachineSale() {
		
		System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s%6$s%n");
		this.totalSaleRecord.put(DrinkType.TEA, new int[] { 0, 0 });
		this.totalSaleRecord.put(DrinkType.COFFEE, new int[] { 0, 0 });
		this.totalSaleRecord.put(DrinkType.BLACK_TEA, new int[] { 0, 0 });
		this.totalSaleRecord.put(DrinkType.BLACK_COFFEE, new int[] { 0, 0 });
		
	}

	public void generateTotalSaleReport() {

		Integer totalNoOFCups, totalCost;
		totalNoOFCups = totalSaleRecord.entrySet().stream().mapToInt(entry -> entry.getValue()[0]).sum();
		totalCost = totalSaleRecord.entrySet().stream().mapToInt(entry -> entry.getValue()[1]).sum();
		LOGGER.info("***Total sale Report***\nTotal Number Of cups: " + totalNoOFCups + "\t Total cost:" + totalCost
				+ "\n");

	}

	public void addTotalCostToSaleRecord(DrinkType drink, int noOfCups, int Cost) {

		int[] quantityAndCost = new int[2];

		quantityAndCost[0] += noOfCups;
		quantityAndCost[1] += Cost;
		
		totalSaleRecord.replace(drink, quantityAndCost);
	}

	public void generateDrinkwiseSaleReport() {

		LOGGER.info("***DrinkWise Sale Report***\n Drink Type\t No of cups  Total cost\n");
		totalSaleRecord.entrySet().stream().forEach(
				entry -> LOGGER.info((entry.getKey() + "  \t" + entry.getValue()[0] + "  " + entry.getValue()[1])));

	}

}
