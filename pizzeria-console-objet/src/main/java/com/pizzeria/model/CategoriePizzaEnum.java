package com.pizzeria.model;

public enum CategoriePizzaEnum {
	
	FROMAGE ("Fromage"),
	VIANDE ("Viande"),
	POISSON("Poisson"),
	AUTRE("Autre");

	
	
	private String CategoriePizza;

	
	
	private CategoriePizzaEnum(String categoriePizza) {
		CategoriePizza = categoriePizza;
	}

	
	
	
	public String getCategoriePizza() {
		return CategoriePizza;
	}

	public void setCategoriePizza(String categoriePizza) {
		CategoriePizza = categoriePizza;
	}
}
