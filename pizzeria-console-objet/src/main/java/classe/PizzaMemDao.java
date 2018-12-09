package classe;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 

import java.util.List;
import java.util.ArrayList;

import java.util.Arrays;



import exception.DeletePizzaException;
import exception.NoPizzaException; 
import exception.SavePizzaException;
import exception.StockageException;
import exception.UpdatePizzaException;



import com.pizzeria.ConnectPizzeria;


public class PizzaMemDao implements IPizzaDao {
	/*
	static ArrayList<Pizza> pizza = new ArrayList<Pizza>();
	static {

	pizza.add(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizzaEnum.VIANDE));
	pizza.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizzaEnum.FROMAGE));
	pizza.add(new Pizza("REIN", "La Reine", 11.50, CategoriePizzaEnum.POISSON));
	pizza.add(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizzaEnum.FROMAGE));
	pizza.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizzaEnum.VIANDE));
	pizza.add(new Pizza("SAV","La savoyarde",13.00, CategoriePizzaEnum.FROMAGE));
	pizza.add(new Pizza("ORI", "L'orientale", 13.50, CategoriePizzaEnum.VIANDE));
	pizza.add(new Pizza("IND", "L'indienne", 14.00, CategoriePizzaEnum.VIANDE));
	
	}
	*/
	
	/*
	String code;
	String nom;
	Double prix;
	*/

	// Pizza[] somePizzas = { pep, mar, rein, fro, can, sav, ori, ind };

	public ArrayList<Pizza> findAllPizzas() {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultat = null;
		
		ArrayList <Pizza> pizzas = new ArrayList<Pizza>();
		
		try {
			connection = ConnectPizzeria.getConnection();
			statement = connection.createStatement();
			String query = "Select * from Pizza JOIN categorie ON pizza.ID_CATEGORIE = categorie.id";
			
			
			resultat = statement.executeQuery(query);
			
			while(resultat.next()) {
				Pizza pizza = new Pizza();
				pizza.setId(resultat.getInt(1));
				pizza.setCode(resultat.getString("CODE"));
				pizza.setDesignation(resultat.getString("designation"));
				pizza.setPrix(resultat.getFloat("PRIX"));
				pizza.setTypePizza(new TypePizza(resultat.getInt("categorie.id"),resultat.getString("categorie.NOM")));
				
				pizzas.add(pizza);
				
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				resultat.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return pizzas;
	}  

	
	public Pizza findPizzaById(int id) throws NoPizzaException {
		
		Connection  connection = null;
		Statement statement = null;
		ResultSet resultat = null;
		
		
		 Pizza pizza = new Pizza();
		try {
			connection = ConnectPizzeria.getConnection();
			statement = connection.createStatement();
			String query = "Select * from Pizza JOIN categorie ON pizza.id_categorie = categorie.id where pizza.id ="+id ;
			
			
			resultat = statement.executeQuery(query);
			
			while(resultat.next()) {
			
				pizza.setId(resultat.getInt(1));
				pizza.setCode(resultat.getString("pizza.CODE"));
				pizza.setDesignation(resultat.getString("pizza.DESIGNATION"));
				pizza.setPrix(resultat.getFloat("pizza.PRIX"));
				pizza.setTypePizza(new TypePizza(resultat.getInt("pizza.ID_CATEGORIE"),resultat.getString("categorie.NOM")));
				
			
				
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NoPizzaException("La pizza n'y est pas");
		}finally {
			try {
				resultat.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return pizza;
	}
	
	public  ArrayList<Pizza> findPizzasByTypeName(String nomPizza) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;
		
		
		ArrayList <Pizza> pizzas = new ArrayList<Pizza>();
		try {
			connection = ConnectPizzeria.getConnection();
	
			String query = "Select * from Pizza JOIN categorie ON pizza.ID_CATEGORIE = categorie.id where categorie.NOM =?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, nomPizza);
			resultat = preparedStatement.executeQuery();
			
			while(resultat.next()) {
				Pizza pizza = new Pizza();
				pizza.setId(resultat.getInt(1));
				pizza.setCode(resultat.getString("pizza.CODE"));
				pizza.setDesignation(resultat.getString("pizza.DESIGNATION"));
				pizza.setPrix(resultat.getFloat("pizza.PRIX"));
				pizza.setTypePizza(new TypePizza(resultat.getInt("categorie.ID"),resultat.getString("categorie.NOM")));
				
				pizzas.add(pizza);
			
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				resultat.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.err.println("Les pizzas de la catégorie " + nomPizza + " : ");
		return pizzas;
	}

	/*
	public Pizza listCode(String code) {
		Pizza pizzou = null;
		for (Pizza pizza : pizza) {
			if(pizza.getCode().equals(code)) {
				pizzou  = pizza;
			}
		} 
		return pizzou;
	} 
	*/
	
	// On vérifie l'existence d'une pizza à l'aide d'un booléen qui détermine sa présence
	// suite au parcours du tableau en utilisant le code de la Pizza en tant que parcoureur
	
	/*
	public boolean isPizzaExists(String code) {
		boolean pizzaPresente = false;
		for (Pizza pizzou : pizza) {
			if(pizzou.getCode().equals(code)) {
				pizzaPresente = true;
			}
		}
		return pizzaPresente;
	}
	*/
	
	
	public boolean isPizzaExists(int id) {
		
		boolean isExisting = true;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultat = null;
		
		
		 Pizza pizza = new Pizza();
		try {
			connection = ConnectPizzeria.getConnection();

			String query = "Select * from Pizza JOIN categorie ON pizza.id_categorie = categorie.id where pizza.id =?" ;
			
		
			statement = connection.prepareStatement(query);
			
			statement.setInt(1, id );
			
			resultat = statement.executeQuery();
			
			if (!resultat.isBeforeFirst() ) {    
			   isExisting = false;
			} 	
		
			while(resultat.next()) {
			
				pizza.setId(resultat.getInt(1));
				pizza.setCode(resultat.getString("pizza.CODE"));
				pizza.setDesignation(resultat.getString("pizza.DESIGNATION"));
				pizza.setPrix(resultat.getDouble("pizza.PRIX"));
				pizza.setTypePizza(new TypePizza(resultat.getInt("CATEGORIE.id"),resultat.getString("CATEGORIE.NOM")));
				
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
		
				
					statement.close();
					connection.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("No run");
				}
			}

		return isExisting;
			
	}


	/*
	public void updatePizza(String code, Pizza editPizza) throws UpdatePizzaException {
		Pizza pizza = findPizzaByCode(code);
		Boolean exist = isPizzaExists(code);
		Boolean sucess = true;
		if(exist) {
			try {
				editPizza.controleDeDonnees();
			} catch (StockageException StockageExceptionCestPasBien) {
				sucess = false;
			}
			if(success) {
				pizza = editPizza;
				}
		}
		else {
			throw new UpdatePizzaException("La pizza n'existe pas");
		}
	}
	
	*/

	public void updatePizza(int id, Pizza editPizza) throws UpdatePizzaException {	
	Pizza pizza;

	Boolean isExisting = isPizzaExists(id);
	Boolean reussite = true;
	
	if(isExisting) {

		
			try {
				editPizza.controleDeDonnees();
			} catch (StockageException exception) {
				System.err.println("pizza pas valide : " + exception.getMessage());
				System.err.println("La pizza ne sera pas mise à jour");
				reussite = false;
				
			}
			
			if(reussite) {
				
		
				Connection connection = null;
				PreparedStatement statement = null;
				int resultat;
				try {
					connection = ConnectPizzeria.getConnection();
			
					String query = "UPDATE pizza SET CODE = ?, DESIGNATION = ?, PRIX = ?, ID_CATEGORIE = ? WHERE pizza.id = " + id;
					
					statement = connection.prepareStatement(query);
					statement.setString(1, editPizza.getCode());
					statement.setString(2, editPizza.getDesignation());
					statement.setDouble(3, editPizza.getPrix());
					statement.setInt(4, editPizza.getTypePizza().getId());
					
					resultat = statement.executeUpdate();
					
					System.out.println("result = " + resultat);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					reussite = false;
			
				}finally {
					try {
						statement.close();
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
		
			}
		
	}	else {
		throw new UpdatePizzaException("La pizza n'est pas existante");
	}
}

	
	public void addPizza(Pizza pizzas) throws SavePizzaException {
		
		boolean bon = true;
		
		try {
			pizzas.controleDeDonnees();
		} catch (StockageException StockageExceptionCestPasBien) {
			bon = false;
			System.out.println("pas d'ajout possible");
		}
		
		
		
		if(bon) {
			// pizzas.add(pizzi);
			
			Connection co = null;
			PreparedStatement prepareStatement = null;
			
			try {
				co = ConnectPizzeria.getConnection();
				String query = "INSERT INTO pizza(CODE,DESIGNATION, PRIX, ID_CATEGORIE)VALUES(?,?,?,?)";
				prepareStatement = co.prepareStatement(query);
				prepareStatement.setString(1, pizzas.getCode());
				prepareStatement.setString(2, pizzas.getDesignation());
				prepareStatement.setDouble(3, pizzas.getPrix());
				prepareStatement.setInt(4, pizzas.getTypePizza().getId());
				
				prepareStatement.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					prepareStatement.close();
					co.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	
	public void listPizza(ArrayList <Pizza> pizzas) {
		
		System.out.println(" Liste des pizzas");
		for (Pizza pizza : pizzas) {
			System.out.println(pizza.toString());			
		}	
	}
	

	

	/*
	public void deletePizza(String code) throws DeletePizzaException {
		
		

		boolean vrai = isPizzaExists(code);
		
		if(vrai) {
			
		for(int i = 0; i<pizza.size(); i++) {
		
			if(pizza.get(i).getCode().equals(code)) {
			 pizza.remove(pizza.get(i));

				System.out.println("Pizza supprimée");
			}
		}
		


		} else {
			throw new DeletePizzaException("Ce code n'y est pas");
			
		}
		
	}
	*/
	
public void deletePizza(int id) throws DeletePizzaException{
		
		Boolean exist = isPizzaExists(id);
		System.out.println(exist +" laa");
		if(exist) {
			
			Connection co = null;
			Statement statement = null;
			int result;
			
			try {
				co = ConnectPizzeria.getConnection();
				statement = co.createStatement();
				String query = "DELETE FROM pizza WHERE id="+id;
				result = statement.executeUpdate(query);
				System.err.println("Pizza supprimé");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
				
					statement.close();
					co.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
		


		} else {
			throw new DeletePizzaException("L'id de la pizza entrer n'existe pas");
			
		}
		
	}

	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		for (Pizza pizza : pizza) {
			if(pizza.getCode().equals(codePizza)) {
				return pizza;
			}
		}
		return null;
	}


	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		// TODO Auto-generated method stub
		
	}


	public boolean isPizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}


	public void deletePizza(String codePizza) throws DeletePizzaException {
		// TODO Auto-generated method stub
		
	}


	public void listPizza() {
		// TODO Auto-generated method stub
		
	}
	

}
