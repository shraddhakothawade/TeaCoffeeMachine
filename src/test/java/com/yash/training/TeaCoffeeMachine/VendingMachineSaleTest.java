package com.yash.training.TeaCoffeeMachine;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.training.model.DrinkType;

@RunWith(MockitoJUnitRunner.class)
public class VendingMachineSaleTest {

	@InjectMocks
	VendingMachineSale vendingMachineSale;

	@Mock
	private Logger LOGGER;

	@Test
	public void shouldDisplaySaleReportAsTotalNoOfCupsAndCost() {

		doNothing().when(LOGGER).info(anyString());
		
		vendingMachineSale.addTotalCostToSaleRecord(DrinkType.TEA, 10, 100);
		vendingMachineSale.generateTotalSaleReport();

		verify(LOGGER).info(anyString());

	}

	@Test
	public void shouldDisplaySaleReportDrinkWiseAsNoOfCupsAndCost() {
		
		doNothing().when(LOGGER).info(anyString());
		
		vendingMachineSale.addTotalCostToSaleRecord(DrinkType.TEA, 10, 100);
		vendingMachineSale.generateDrinkwiseSaleReport();
		
		verify(LOGGER, times(5)).info(anyString());

	}
}
