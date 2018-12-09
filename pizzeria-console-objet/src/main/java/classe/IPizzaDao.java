package classe;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import exception.DeletePizzaException; 
import exception.NoPizzaException;
import exception.SavePizzaException; 
import exception.UpdatePizzaException;

public interface IPizzaDao {
	
	List<Pizza> findAllPizzas();
	void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;
	Pizza findPizzaById(int id) throws NoPizzaException;
	Pizza findPizzaByCode(String codePizza);
	boolean isPizzaExists(int id);
	void addPizza(Pizza pizza) throws SavePizzaException;
	void deletePizza(int id) throws DeletePizzaException;
	void listPizza(ArrayList <Pizza> pizzas);
}
  