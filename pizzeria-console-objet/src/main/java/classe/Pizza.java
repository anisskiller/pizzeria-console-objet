package classe;

public class Pizza {
public String code;
public String designation;
public double prix;

/**
 * 
 * @param code => code de la pizza (Majuscule)
 * @param designation => nom de la pizza
 * @param prix => prix de la pizza
 */

// constructeur 
public Pizza(String code, String designation, double prix) {
	this.code = code;
	this.designation = designation;
	this.prix = prix;
}


// getters 

/**
 * 
 * @return retourne le code de la pizza
 * @return retourne le nom de la pizza
 * @return retourne le prix de la pizza
 */

public String getCode() {
	return code;
}

public String getDesignation() {
	return designation;
}

public double getPrix() {
	return prix;
}


// setters 

/**
 * 
 * @param modifie le code de la pizza
 * @param modifie le nom de la pizza
 * @param modifie le prix de la pizza
 */
public void setCode(String code) {
	this.code = code;
}

public void setDesignation(String designation) {
	this.designation = designation;
}

public void setPrix(double prix) {
	this.prix = prix;
}

/**
 * 
 * @return affiche le menu d el'application
 */

public static String afficheMenu() {
	return "***** Pizzeria Administration *****\r\n" + "1.	  Lister les pizzas\r\n" + "2.	  Ajouter une nouvelle pizza\r\n" + "3.	  Mettre à jour une pizza\r\n" + "4.	  Supprimer une pizza\r\n" + "99.	  Sortir";
}
	
}
