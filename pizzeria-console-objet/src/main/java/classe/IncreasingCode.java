package classe;

import java.util.Comparator;

public class IncreasingCode implements Comparator<Pizza> {


	public int compare(Pizza p1, Pizza p2) {

		int comparisonCodePizza = 0;
		comparisonCodePizza = p1.getCode().compareTo(p2.getCode());
		return comparisonCodePizza;
	}
	
	

}
