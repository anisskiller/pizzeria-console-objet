package classe;

public class TypePizza {
	private int id;
	private String pizza;
	
	public TypePizza() {
		
	}
	
	public TypePizza(int id) {
		this.id = id;
	}
	public TypePizza(int id, String pizza) {
		this.id = id;
		this.pizza = pizza;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPizza() {
		return pizza;
	}
	public void setPizza(String pizza) {
		this.pizza = pizza;
	}
	
	
	public String toString() {
		return  " Catégorie : "  +  pizza;
	}
}
