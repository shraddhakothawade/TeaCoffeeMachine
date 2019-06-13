package com.yash.training.TeaCoffeeMachine;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.training.model.DrinkType;
import com.yash.training.serviceImpl.VendingMachineServiceImpl;
import com.yash.training.util.IntegerScanner;

@RunWith(MockitoJUnitRunner.class)
public class VendingMachineMenuTest {

	@InjectMocks
	private VendingMachineMenu vendingMachineMenu;

	@Mock
	private VendingMachineServiceImpl vendingMachineService;

	@Mock
	private IntegerScanner scanner;

	@Mock
	private Logger LOGGER;

	@Test
	public void shouldCallRequestDrinkMethodForCoffee() {

		when(scanner.nextInt()).thenReturn(1, 2);
		doNothing().when(LOGGER).info(anyString());
		when(vendingMachineService.prepareDrink(DrinkType.COFFEE, 2)).thenReturn(30);

		vendingMachineMenu.vendingMachineMenuList(false);

		verify(vendingMachineService).prepareDrink(DrinkType.COFFEE, 2);
		verify(LOGGER, times(4)).info(anyString());
	}

	@Test
	public void shouldCallRequestDrinkMethodForTea() {

		when(scanner.nextInt()).thenReturn(2, 2);
		doNothing().when(LOGGER).info(anyString());
		when(vendingMachineService.prepareDrink(DrinkType.TEA, 2)).thenReturn(20);

		vendingMachineMenu.vendingMachineMenuList(false);

		verify(vendingMachineService).prepareDrink(DrinkType.TEA, 2);
		verify(LOGGER, times(4)).info(anyString());
	}

	@Test
	public void shouldCallRequestDrinkMethodForBlackTea() {

		when(scanner.nextInt()).thenReturn(3, 5);
		doNothing().when(LOGGER).info(anyString());
		when(vendingMachineService.prepareDrink(DrinkType.BLACK_TEA, 5)).thenReturn(25);

		vendingMachineMenu.vendingMachineMenuList(false);

		verify(vendingMachineService).prepareDrink(DrinkType.BLACK_TEA, 5);
		verify(LOGGER, times(4)).info(anyString());
	}

	@Test
	public void shouldCallRequestDrinkMethodForBlackCoffee() {

		when(scanner.nextInt()).thenReturn(4, 2);
		doNothing().when(LOGGER).info(anyString());
		when(vendingMachineService.prepareDrink(DrinkType.BLACK_COFFEE, 2)).thenReturn(20);

		vendingMachineMenu.vendingMachineMenuList(false);

		verify(vendingMachineService).prepareDrink(DrinkType.BLACK_COFFEE, 2);
		verify(LOGGER, times(4)).info(anyString());
	}

	@Test
	public void shouldDisplayContainerStatus() {

		doNothing().when(LOGGER).info(anyString());
		when(scanner.nextInt()).thenReturn(5);
		doNothing().when(vendingMachineService).showContainerStatus();

		vendingMachineMenu.vendingMachineMenuList(false);

		verify(vendingMachineService).showContainerStatus();
		

	}
	
	@Test
	public void shouldResetContainerToIntialCapacity() {

		when(scanner.nextInt()).thenReturn(6);
		doNothing().when(LOGGER).info(anyString());
		when(scanner.nextInt()).thenReturn(6);
		doNothing().when(vendingMachineService).resetContainer();

		vendingMachineMenu.vendingMachineMenuList(false);

		verify(vendingMachineService).resetContainer();
		
	}
	
	@Test
	public void shouldRefillContainer() {

		when(scanner.nextInt()).thenReturn(7, 1000, 0, 10000, 2000, 3000);
		doNothing().when(LOGGER).info(anyString());
		doNothing().when(vendingMachineService).refillContainer(1000, 0, 10000, 2000, 3000);

		vendingMachineMenu.vendingMachineMenuList(false);

		verify(vendingMachineService).refillContainer(1000, 0, 10000, 2000, 3000);
		verify(LOGGER, times(7)).info(anyString());
	}

	

	@Test
	public void shouldDisplayTotalSaleAsCupAndCost() {

		Map<DrinkType, int[]> totalSaleRecord = new HashMap<DrinkType, int[]>();
		totalSaleRecord.put(DrinkType.TEA, new int[] { 5, 50 });
		totalSaleRecord.put(DrinkType.COFFEE, new int[] { 20, 300 });

		
		doNothing().when(LOGGER).info(anyString());
		when(scanner.nextInt()).thenReturn(8);
		doNothing().when(vendingMachineService).generateDrinkwiseSaleReport();
		doNothing().when(vendingMachineService).generateTotalSaleReport();

		vendingMachineMenu.vendingMachineMenuList(false);

		verify(vendingMachineService).generateDrinkwiseSaleReport();
		verify(vendingMachineService).generateTotalSaleReport();
		
	}

	@Test
	public void shouldExitFromVendingMachine() {

		doNothing().when(LOGGER).info(anyString());
		when(scanner.nextInt()).thenReturn(9);
		
		vendingMachineMenu.vendingMachineMenuList(true);
		
	}
	
	@Test
	public void shouldDisplayWarningMessageForInvalidSelection(){
		
		doNothing().when(LOGGER).info(anyString());
		when(scanner.nextInt()).thenReturn(10);
		
		vendingMachineMenu.vendingMachineMenuList(false);
	}
}
