package classe;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.NoPizzaException;
import exception.UpdatePizzaException;

import com.pizzeria.ConnectPizzeria;

public class TypePizzaDao implements ITypePizzaDao {
	
public ArrayList<TypePizza> findAllTypePizza() {
		
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultat = null;
		
		
		ArrayList <TypePizza> typesPizza = new ArrayList<TypePizza>();
		try {
			connection = ConnectPizzeria.getConnection();
			statement = connection.createStatement();
			String query = "SELECT * FROM categorie";
			
			
			resultat = statement.executeQuery(query);
			
			while(resultat.next()) {
				TypePizza typePizza = new TypePizza();
				typePizza.setId(resultat.getInt("categorie.ID"));
				typePizza.setPizza(resultat.getString("categorie.NOM"));
				
				typesPizza.add(typePizza);
				
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
		return typesPizza;
		
	}
	
	public void updateCategorie(int id, String nomTypePizza)  {
		
		
		Connection connection = null;
		PreparedStatement statement = null;
		int resultat;
		try {
			connection = ConnectPizzeria.getConnection();
	
			String query = "UPDATE categorie SET NOM = ? WHERE pizza.id = " + id ;
			
			statement = connection.prepareStatement(query);
			
			statement.setString(1, nomTypePizza);

			
			resultat = statement.executeUpdate();
			
			System.out.println("result = " + resultat);
		} catch (Exception e) {
			// TODO Auto-generated catch block
	
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
		
	

	public TypePizza findTypePizzaById(int id) throws NoPizzaException {
		// TODO Auto-generated method stub
		Connection  connection = null;
		Statement statement = null;
		ResultSet resultat = null;
		
		
		TypePizza typePizza = new TypePizza();
		try {
			connection = ConnectPizzeria.getConnection();
			statement = connection.createStatement();
			String query = "Select * from Categorie where id="+id;
			
			
			resultat = statement.executeQuery(query);
			
			while(resultat.next()) {
		
				typePizza.setId(resultat.getInt("categorie.ID"));
				typePizza.setPizza(resultat.getString("categorie.NOM"));
				
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
		return typePizza;
	}
	
	
	public void listTypePizza(ArrayList<TypePizza> typesPizza) {
		// TODO Auto-generated method stub
		for (TypePizza typePizza : typesPizza) {
			System.out.println(typePizza);
		}
	}

	public void updateTypePizza(int id, String nomTypePizza) {
		// TODO Auto-generated method stub
		
	}

	public TypePizza findTypePizza(int id) throws NoPizzaException {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object findPizzasByTypeName(String nextLine) {
		// TODO Auto-generated method stub
		return null;
	}



}
