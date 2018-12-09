package classe;

import java.util.ArrayList;
import java.util.List;

import exception.NoPizzaException;
import exception.UpdatePizzaException;

public interface ITypePizzaDao {
	ArrayList <TypePizza> findAllTypePizza();
	void updateTypePizza(int id, String nomTypePizza);
	TypePizza findTypePizza(int id) throws NoPizzaException;
	void listTypePizza(ArrayList <TypePizza> typesPizza);
}
