package classe;


public abstract class PizzaMemDao implements IPizzaDao {
	

	Pizza pep = new Pizza("PEP", "Pépéroni", 12.50);
	Pizza mar = new Pizza("MAR", "Margherita", 14.00);
	Pizza rein = new Pizza("REIN", "La Reine", 11.50);
	Pizza fro = new Pizza("FRO", "La 4 fromages", 12.00);
	Pizza can = new Pizza("CAN", "La cannibale", 12.50);
	Pizza ori = new Pizza("ORI", "L'orientale", 13.50);
	Pizza ind = new Pizza("IND", "L'indienne", 14.00);
	String code;
	String name;
	Double prix;

	Pizza[] somePizzas = { pep, mar, rein, fro, can, ori, ind };

	public Pizza[] listPizzas() {
		return somePizzas;
	}  

	public Pizza listCode(String code) {
		Pizza pizzou = null;
		for (Pizza pizza : somePizzas) {
			if(pizza.getCode().equals(code)) {
				pizzou  = pizza;
			}
		} 
		return pizzou;
	} 
	
	// On vérifie l'existence d'une pizza à l'aide d'un booléen qui détermine sa présence
	// suite au parcours du tableau en utilisant le code de la Pizza en tant que parcoureur
	public boolean pizzaOuPasPizza(String code) {
		boolean pizzaPresente = false;
		for (Pizza pizzou : somePizzas) {
			if(pizzou.getCode().equals(code)) {
				pizzaPresente = true;
			}
		}
		return pizzaPresente;
	}



	public void modifierPizza(String code, Pizza pizza) {
		for (Pizza editPizza : somePizzas) {
			if (editPizza.getCode().equals(code)) {
				editPizza = pizza;
			}

		}
	}

	public void ajouterPizza(Pizza pizza) {
		Pizza[] nouvellePizza = new Pizza[somePizzas.length + 1];

		for (int i = 0; i < somePizzas.length; i++) {
			nouvellePizza[i] = somePizzas[i];
		}
		nouvellePizza[nouvellePizza.length - 1] = pizza;
		somePizzas = nouvellePizza;
	}

	public void supprimerPizza(String code) {
		Pizza[] nouvellePizza = new Pizza[somePizzas.length - 1];
		int i = 0;
		for (Pizza pizzou : somePizzas) {

			if (!pizzou.getCode().equals(code)) {
				nouvellePizza[i] = pizzou;
				i++;
			}
		}
		somePizzas = nouvellePizza;
	}


	
	

}
