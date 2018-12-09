package classe;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.pizzeria.ConnectPizzeria;

public class RebootDatabase {

	public static void delete(ConnectPizzeria connection) {
		
		
		
		
		Statement statement = null;
		int result=0;
		

		try {
			
			connection.setAutoCommit(false);
			statement = connection.createStatement();
			
			
			String query = "TRUNCATE pizza";
			result += statement.executeUpdate(query);
			
			query = "SET FOREIGN_KEY_CHECKS = 0";
			result += statement.executeUpdate(query);
			
			query = "TRUNCATE categorie";
			result += statement.executeUpdate(query);
			
			query = "SET FOREIGN_KEY_CHECKS = 1"; 
			result += statement.executeUpdate(query);
			
			
			System.err.println("Donnée effacée");
			connection.commit();
		
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				connection.setAutoCommit(true);
				statement.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}

	
	public static void add(ConnectPizzeria connection) {
		
		
		

		Statement statement = null;
		int resultat = 0;
		

		try {
			
			connection.setAutoCommit(false);
			statement = connection.createStatement();
			
			
			String query = "INSERT INTO `CATEGORIE` (`ID`, `NOM`) VALUES \n(4, 'AUTRE'),\n(1, 'FROMAGE'),\n(3, 'POISSON'),\n(2, 'VIANDE')";
			resultat += statement.executeUpdate(query);
			
			query = "INSERT INTO `PIZZA` (`ID`, `CODE`, `DESIGNATION`, `PRIX`, `ID_CATEGORIE`) VALUES\n (1, 'PEP', 'PEPERONI', 7.2, 4),\r\n" + 
					"(2, 'MAR', 'MARGHERITA', 8.2, 1),\n(3, 'REI', 'LA REINE', 6.8, 1),\n" + 
					"(4, 'FRO', '4 FROMAGES', 8.1, 1),\n(5, 'CAN', 'CANADIENNE', 9.3, 2),\n(6, 'ORI', 'ORIENTALE', 10.4, 2),\n(7, 'IND', 'INDIENNE', 10.2, 4)";
			resultat += statement.executeUpdate(query);
			
			
			System.err.println("Donnée remise ");
			connection.commit();
		
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				connection.setAutoCommit(true);
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
