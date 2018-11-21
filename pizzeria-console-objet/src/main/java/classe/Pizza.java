package classe;

public class Pizza {

	public int id;
	public String code;
	public String designation;
	public double prix;
	
	private static  int count = 0;
	
	/**
	 * @param id : identifiant de la pizza
	 * @param code : code de la pizza
	 * @param designation : nom de la pizza
	 * @param prix : Prix de la pizza
	 */

	
	public String toString() {
		return code + " -> " + designation + "("+ prix + "€)";
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


	public Pizza(String code, String designation, double prix) {
		this.id = count++;
		this.code = code;
		this.designation = designation;
		this.prix = prix;			
	}
	
}
