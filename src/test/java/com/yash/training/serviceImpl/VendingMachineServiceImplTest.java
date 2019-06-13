package com.yash.training.serviceImpl;

import static org.junit.Assert.assertEquals;
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

import com.yash.training.TeaCoffeeMachine.VendingMachineSale;
import com.yash.training.model.DrinkType;

@RunWith(MockitoJUnitRunner.class)
public class VendingMachineServiceImplTest {
	@InjectMocks
	private VendingMachineServiceImpl vendingMachineService;

	@Mock
	private VendingMachineSale vendingMachine;

	@Mock
	private Logger LOGGER;

	@Test
	public void shouldReturnCostOfTwoCupsOfTea() {

		Integer ExpectedCost = 20;

		doNothing().when(vendingMachine).addTotalCostToSaleRecord(DrinkType.TEA, 2, 20);

		Integer actualCost = vendingMachineService.prepareDrink(DrinkType.TEA, 2);

		assertEquals(ExpectedCost, actualCost);
	}

	@Test
	public void shouldReturnCostOfOneCupsOfCoffee() {
		Integer ExpectedCost = 15;

		doNothing().when(vendingMachine).addTotalCostToSaleRecord(DrinkType.COFFEE, 1, ExpectedCost);

		Integer actualCost = vendingMachineService.prepareDrink(DrinkType.COFFEE, 1);

		assertEquals(ExpectedCost, actualCost);
	}

	@Test
	public void shouldReturnCostOfTwoCupsOfBlackTea() {
		Integer ExpectedCost = 10;

		doNothing().when(vendingMachine).addTotalCostToSaleRecord(DrinkType.BLACK_TEA, 2, ExpectedCost);

		Integer actualCost = vendingMachineService.prepareDrink(DrinkType.BLACK_TEA, 2);

		assertEquals(ExpectedCost, actualCost);
	}

	@Test
	public void shouldReturnCostOfThreeCupsOfBlackCoffee() {
		
		Integer ExpectedCost = 30;

		Integer actualCost = vendingMachineService.prepareDrink(DrinkType.BLACK_COFFEE, 3);

		assertEquals(ExpectedCost, actualCost);

	}

	@Test
	public void shouldReturnZeroWhenInsufficientQuantityOfMilk() {
		
		Integer ExpectedCost = 0;

		doNothing().when(vendingMachine).addTotalCostToSaleRecord(DrinkType.TEA, 250, ExpectedCost);

		Integer actualCost = vendingMachineService.prepareDrink(DrinkType.TEA, 250);

		assertEquals(ExpectedCost, actualCost);

	}
	
	@Test
	public void shouldReturnZeroAndDisplayInsufficientQuantityForTea(){
		
		Integer ExpectedCost = 0;
		

		doNothing().when(vendingMachine).addTotalCostToSaleRecord(DrinkType.TEA, 335, ExpectedCost);

		Integer actualCost = vendingMachineService.prepareDrink(DrinkType.TEA, 335);

		assertEquals(ExpectedCost, actualCost);
	}
	
	@Test
	public void shouldReturnZeroAndDisplayInsufficientQuantityForCoffee(){
		
		Integer ExpectedCost = 0;
		

		doNothing().when(vendingMachine).addTotalCostToSaleRecord(DrinkType.COFFEE, 400, ExpectedCost);

		Integer actualCost = vendingMachineService.prepareDrink(DrinkType.COFFEE, 400);

		assertEquals(ExpectedCost, actualCost);
	}
	
	@Test
	public void shouldReturnZeroAndDisplayInsufficientQuantityForWater(){
		
		Integer ExpectedCost = 0;
		

		doNothing().when(vendingMachine).addTotalCostToSaleRecord(DrinkType.BLACK_TEA, 134, ExpectedCost);

		Integer actualCost = vendingMachineService.prepareDrink(DrinkType.BLACK_TEA, 134);

		assertEquals(ExpectedCost, actualCost);
	}
	
	@Test
	public void shouldReturnZeroAndDisplayInsufficientQuantityForSugar(){
		
		Integer ExpectedCost = 0;
		

		doNothing().when(vendingMachine).addTotalCostToSaleRecord(DrinkType.BLACK_TEA, 471, ExpectedCost);

		Integer actualCost = vendingMachineService.prepareDrink(DrinkType.BLACK_TEA, 471);

		assertEquals(ExpectedCost, actualCost);
	}
	
	@Test
	public void shouldDisplayContainerStatus() {

		doNothing().when(LOGGER).info(anyString());

		vendingMachineService.showContainerStatus();

		verify(LOGGER, times(5)).info(anyString());

	}

	@Test
	public void shouldResetContainerToInitailCapacity(){
		
		doNothing().when(LOGGER).info(anyString());

		vendingMachineService.resetContainer();

		verify(LOGGER).info(anyString());
	}
	
	@Test
	public void shouldRefillContainerAndUpdateContainer() {
		
		doNothing().when(LOGGER).warning(anyString());
		doNothing().when(vendingMachine).addTotalCostToSaleRecord(DrinkType.BLACK_TEA, 471, 50);
		
		vendingMachineService.prepareDrink(DrinkType.BLACK_TEA, 10);
		
		vendingMachineService.refillContainer(30, 0, 0, 0, 0);	
	}
	
	@Test
	public void shouldDisplayOverflowMessageForQuantityMoreThanCapacityOfContainer() {
		
		doNothing().when(LOGGER).warning(anyString());
		
		vendingMachineService.refillContainer(0, 2000, 15000, 1000, 8000);	
		
		verify(LOGGER, times(4)).warning(anyString());
	}
	
	@Test
	public void shouldNotIncrementRefillCounterAsAllQuantitiesMoreThanCapatity() {
		
		doNothing().when(LOGGER).warning(anyString());
		
		vendingMachineService.refillContainer(2000, 2000, 15000, 1000, 8000);	
		
		verify(LOGGER, times(5)).warning(anyString());
	}
	
	
	
}
