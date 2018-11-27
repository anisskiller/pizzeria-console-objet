package classe;

import java.util.Comparator;

public class DecreasingPrice implements Comparator<Pizza> {

	public int compare(Pizza pizza1, Pizza pizza2) {
		// TODO Auto-generated method stub
		
		
		int ComparisonPricePizza = 0;
		if(pizza1.getPrix()>pizza2.getPrix()) {
			ComparisonPricePizza = 1;
		}else {
			ComparisonPricePizza = -1;
		}
		return ComparisonPricePizza;
		
		
	}


	

}
