package classe;

import java.util.Comparator;

public class IncreasingCode implements Comparator<Pizza> {


	
	public int compare(Pizza o1, Pizza o2) {
		// TODO Auto-generated method stub
		int comparisonCodePizza = o1.getCode().compareTo(o2.getCode());
		return comparisonCodePizza;
	}

}
