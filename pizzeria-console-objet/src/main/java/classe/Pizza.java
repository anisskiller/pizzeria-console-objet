package classe;

import com.pizzeria.model.CategoriePizzaEnum;

import exception.StockageException;

public class Pizza {

	public int id;
	public String code;
	public String designation;
	public double prix;
	
	private static  int count = 0;
	private CategoriePizzaEnum CategoriePizza;
	
	 
	 private final int GRAND_PRIX = 20;
	 private final int PETIT_PRIX = 1;
	 private final int LONGUEUR_CODE = 4;
	
	/**
	 * @param id : identifiant de la pizza
	 * @param code : code de la pizza
	 * @param designation : nom de la pizza
<<<<<<< HEAD
	 * @param prix : Prix de la pizza 
=======
	 * @param prix : Prix de la pizza
>>>>>>> branch 'master' of https://github.com/anisskiller/pizzeria-console-objet.git
	 */

	
	public String toString() {
		return code + " -> " + designation + "("+ prix + "€) | Catégorie : " + CategoriePizza;
	}

	public Pizza() {
		
	}

	/**
	 * 
	 * @return l'id de la pizza
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @param id modifie l'id de la pizza
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 * @return le code de la pizza
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 
	 * @param code de la pizza
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 
	 * @return nom de la pizza
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * 
	 * @param nom de la pizza
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	/**
	 * 
	 * @return le prix en float de la pizza en euro
	 */
	public double getPrix() {
		return prix;
	}
	/**
	 *
	 * @param prix de la pizza en float
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public CategoriePizzaEnum getCategoriePizza() {
		return CategoriePizza;
	}

	public void setCategoriePizza(CategoriePizzaEnum categoriePizza) {
		CategoriePizza = categoriePizza;
	}


	public Pizza(String code, String designation, double prix, CategoriePizzaEnum CategoriePizza) {
		this.id = count++;
		this.code = code;
		this.designation = designation;
		this.prix = prix;
		this.CategoriePizza = CategoriePizza; 
	}
	
	
	public void controleDeDonnees() throws StockageException{
		
		String info = "";
		
		if(this.id<0) {
			info += " ID ne peut pas être inférieur à zéro. \r\n";
		}
		
		if(this.code.trim().length()> LONGUEUR_CODE) {
			info += " Le code ne dépasse pas " + LONGUEUR_CODE + " caractères \n";
		}
		if(this.prix < PETIT_PRIX || this.prix > GRAND_PRIX) {
			info +=  " Le prix ne peut pas être en dehors de " + PETIT_PRIX + " et " + GRAND_PRIX + "\n";
		}
		
		if(!info.isEmpty() ||  info.trim().length() > 0) {
			System.out.println("validé par le contrôle de données");
			throw new StockageException(info);
		}
	}

	
	
}
