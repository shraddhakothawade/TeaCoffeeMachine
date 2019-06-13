package com.yash.training.service;

import com.yash.training.model.ContainerDTO;

public interface Container {

	void showContainerStatus();
	void resetContainer();
	void refillContainer(Integer teaQuantity, Integer coffeeQuantity, Integer waterQuantity, Integer milkQuantity, Integer sugarQuantity);
	
	default void updateContainer(ContainerDTO container,Integer teaQuantity,Integer coffeeQuantity,Integer waterQuantity,Integer milkQuantity,Integer sugarQuantity){
		container.setTeaQuantity(teaQuantity);
		container.setCoffeeQuantity(coffeeQuantity);
		container.setWaterQuantity(waterQuantity);
		container.setMilkQuantity(milkQuantity);
		container.setSugarQuantity(sugarQuantity);
	}
}
