package classe;

import java.util.Comparator;

public class IncreasingCode implements Comparator<Pizza> {


	public int compare(Pizza pizza1, Pizza pizza2) {

		int comparisonCodePizza = 0;
		comparisonCodePizza = pizza1.getCode().compareTo(pizza2.getCode());
		return comparisonCodePizza;
	}
	
	

}
