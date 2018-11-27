package classe;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import com.pizzeria.model.CategoriePizzaEnum;


import exception.DeletePizzaException;
import exception.SavePizzaException;
import exception.StockageException;
import exception.UpdatePizzaException;


public class PizzaMemDao implements IPizzaDao {
	
	static ArrayList<Pizza> pizza = new ArrayList<Pizza>();
	static {

	pizza.add(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizzaEnum.VIANDE));
	pizza.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizzaEnum.FROMAGE));
	pizza.add(new Pizza("REIN", "La Reine", 11.50, CategoriePizzaEnum.POISSON));
	pizza.add(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizzaEnum.FROMAGE));
	pizza.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizzaEnum.VIANDE));
	pizza.add(new Pizza("SAV","La savoyarde",13.00, CategoriePizzaEnum.FROMAGE));
	pizza.add(new Pizza("ORI", "L'orientale", 13.50, CategoriePizzaEnum.VIANDE));
	pizza.add(new Pizza("IND", "L'indienne", 14.00, CategoriePizzaEnum.VIANDE));
	
	}
	
	/*
	String code;
	String nom;
	Double prix;
	*/

	// Pizza[] somePizzas = { pep, mar, rein, fro, can, sav, ori, ind };

	public List<Pizza> findAllPizzas() {
		return pizza;
	}  

	public Pizza listCode(String code) {
		Pizza pizzou = null;
		for (Pizza pizza : pizza) {
			if(pizza.getCode().equals(code)) {
				pizzou  = pizza;
			}
		} 
		return pizzou;
	} 
	
	// On vérifie l'existence d'une pizza à l'aide d'un booléen qui détermine sa présence
	// suite au parcours du tableau en utilisant le code de la Pizza en tant que parcoureur
	public boolean isPizzaExists(String code) {
		boolean pizzaPresente = false;
		for (Pizza pizzou : pizza) {
			if(pizzou.getCode().equals(code)) {
				pizzaPresente = true;
			}
		}
		return pizzaPresente;
	}



	public void updatePizza(String code, Pizza editPizza) throws UpdatePizzaException {
		Pizza pizza = findPizzaByCode(code);
		Boolean exist = isPizzaExists(code);
		Boolean sucess = true;
		if(exist) {
			try {
				editPizza.controleDeDonnees();
			} catch (StockageException StockageExceptionCestPasBien) {
				sucess = false;
			}
			if(sucess) {
				pizza = editPizza;
				}
		}
		else {
			throw new UpdatePizzaException("La pizza n'existe pas");
		}
	}

	public void addPizza(Pizza pizzi) throws SavePizzaException {
		
		boolean bon = true;
		
		try {
			pizzi.controleDeDonnees();
		} catch (StockageException StockageExceptionCestPasBien) {
			bon = false;
		}
		
		
		
		if(bon == true) {
			pizza.add(pizzi);
		}
	}

	
	public void listPizza() {
		
		System.out.println(" Liste des pizzas");
		for (Pizza pizza : pizza) {
			System.out.println(pizza.toString());			
		}	
	}
	

	

	
	public void deletePizza(String code) throws DeletePizzaException {
		
		

		boolean vrai = isPizzaExists(code);
		
		if(vrai) {
			
		for(int i = 0; i<pizza.size(); i++) {
		
			if(pizza.get(i).getCode().equals(code)) {
			 pizza.remove(pizza.get(i));

				System.out.println("Pizza supprimée");
			}
		}
		


		} else {
			throw new DeletePizzaException("Ce code n'y est pas");
			
		}
		
	}

	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		for (Pizza pizza : pizza) {
			if(pizza.getCode().equals(codePizza)) {
				return pizza;
			}
		}
		return null;
	}
	

}
