package classe;
import exception.UpdatePizzaException; 
import exception.DeletePizzaException; 
import exception.SavePizzaException; 
public interface IPizzaDao {
	
	Pizza[] findAllPizzas();
	void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;
	Pizza findPizzaByCode(String codePizza);
	boolean isPizzaExists(String codePizza);
	void addPizza(Pizza pizza) throws SavePizzaException;
	void deletePizza(String codePizza) throws DeletePizzaException;
}
  