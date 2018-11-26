package classe;

import java.util.Comparator;

public class DecreasingPrice implements Comparator<Pizza> {

	public int compare(Pizza pizza1, Pizza pizza2) {
		// TODO Auto-generated method stub
		
		int comparisonPricePizza = Double.compare(pizza2.getPrix(), pizza1.getPrix()); 
		return comparisonPricePizza;
	}


	

}
