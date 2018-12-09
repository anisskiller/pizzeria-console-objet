package com.pizzeria;
import classe.PizzaMemDao;



import java.util.Scanner;

import com.pizzeria.model.CategoriePizzaEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import exception.DeletePizzaException;
import exception.SavePizzaException;
import exception.UpdatePizzaException;
import classe.DecreasingPrice;
import classe.IncreasingCode;
import classe.Pizza;
import classe.TypePizza;
import classe.TypePizzaDao;
import classe.ITypePizzaDao;
import classe.PizzaMemDao;
import classe.RebootDatabase;

public class PizzeriaAdminConsoleApp {
	
	public static <T> void main(String[] args) throws UpdatePizzaException {
		// PizzaMemDao pizza = new PizzaMemDao();
		
		// Pizza [] pizzas = dao.findAllPizzas(); 
		

		PizzaMemDao outilAccessData = new PizzaMemDao();
		
		TypePizzaDao typePizzaDao = new TypePizzaDao();
		
		Scanner sc = new Scanner(System.in); 
		
		boolean next = true;
		int option = 0;

		
		ArrayList<Pizza> pizzas = outilAccessData.findAllPizzas();

		while(next == true) {
			
			System.out.println("***** Pizzeria Administration *****" + 
		"\n1.	  Lister les pizzas" + "\n2.	  Ajouter une nouvelle pizza" + 
		"\n3.	  Mettre à jour une pizza" + "\n4.	  Supprimer une pizza" + 
		"\n5. 	  Trier par prix décroissant" +  
		"\n6.     Trier par code croissant" + "\n7.     Catégorie pizza" + "\n8.     Reboot Database"
		+ "\n99.	  Sortir");



		option = sc.nextInt();

		if(option == 1) {
			
			System.out.println(" Liste des pizzas");
			
			outilAccessData.listPizza();
		
			

		} else if(option == 2) {
	
			System.out.println("Ajouter pizza");
			// remise a 0 du scanner
			sc.nextLine();
	
			System.out.println("Code :");
			String code = sc.nextLine();
	
			System.out.println("Nom :");
			String nom = sc.nextLine();
				
			System.out.println("Prix :");	
			double prix = sc.nextDouble();
			
			System.out.println("Categorie :");
			sc.nextLine();
			
			TypePizzaDao.listTypePizza(TypePizzaDao.findAllTypePizza());
			/*
			try {
				// verification du type de pizza et presence du type
				// CategoriePizzaEnum categorie = CategoriePizzaEnum.valueOf(sc.nextLine().toUpperCase());
				Pizza pizzaToAdd = new Pizza(code, nom, prix, categorie);
				outilAccessData.addPizza(pizzaToAdd);
			} catch (SavePizzaException SauvegarderPizzaExceptionCestPasBien) {
			
			System.err.println(SauvegarderPizzaExceptionCestPasBien.getMessage());
				
			// si le type de pizza existe pas on le met dans autre
			} catch (IllegalArgumentException IllegalCestPasBien) {
				System.out.println("La catégorie n'y est pas ");
				Pizza addPizza = new Pizza(code, nom, prix, CategoriePizzaEnum.AUTRE);
				
				*/
				try {
					Pizza ajoutPizza = new Pizza(code, nom, prix, new TypePizza(sc.nextInt()));
					outilAccessData.addPizza(ajoutPizza);
				} catch (SavePizzaException SauvegarderPizzaExceptionCestPasBien) {
					System.err.println(SauvegarderPizzaExceptionCestPasBien.getMessage());
				
				}
				
			} else if(option == 3) {
	
				System.out.println(" Mettre à jour une pizza");
				
				// remise a 0 du scanner
				sc.nextLine();
				
				// Lister les pizza
				outilAccessData.listPizza(outilAccessData.findAllPizzas());

				
				System.out.println("id : ");
				
				int id = sc.nextInt(); 
				boolean isExisting = outilAccessData.isPizzaExists(id);
			
			if(isExisting) {	
				// Saisie des nouveaux paramètres
				System.out.println(" Nouveau code :");
				String nouveauCode = sc.nextLine();
				System.out.println(" Nouveau nom :");
				String nouveauNom = sc.nextLine();			
				System.out.println(" Nouveau pirx :");
				Double nouveauPrix = sc.nextDouble();
				// sc.nextLine();
				
				TypePizza typePizza = new TypePizza();
				System.out.println(" Catégorie : \n1 => FROMAGE \n2 => VIANDE \n3 => POISSON \n4 => AUTRE \n");	
				//CategoriePizzaEnum categorie;
				
				typePizza.setId(sc.nextInt());
				
				// instanciation 
				Pizza editPizza = new Pizza();
				
			
				editPizza.setCode(nouveauCode);
				editPizza.setDesignation(nouveauNom);
				editPizza.setPrix(nouveauPrix);
				editPizza.setTypePizza(typePizza);
				
				try {
					// verification du type de pizza et presence du type
					 // categorie = CategoriePizzaEnum.valueOf(sc.nextLine().toUpperCase());
					 outilAccessData.updatePizza(id, editPizza);
				}catch (UpdatePizzaException updateEx) {
					// System.err.println("Ce type de pizza n'existe pas, pizza ajoutée a la categorie Autre");
					 // categorie = CategoriePizzaEnum.AUTRE;
					
					System.err.println(updateEx.getMessage());
				}
			} else {
				System.out.println("La pizza n'existe pas");
			}
			
			
			/*
				// instanciation d'une nouvelle pizza pour la modifier
				Pizza editPizza = new Pizza();
				
				// modification de la pizza
				editPizza.setCode(nouveauCode);
				editPizza.setDesignation(nouveauNom);
				editPizza.setPrix(nouveauPrix);
				editPizza.setTypePizza(categorie);
				
				try{
					outilAccessData.updatePizza(codePizza, editPizza);
				}catch(UpdatePizzaException modifierPizzaExceptionCestPasBien) {
					
					System.err.println(modifierPizzaExceptionCestPasBien.getMessage());
				
					
				} 
			
			} else {
					System.err.println("La pizza n'existe pas");
				}
		*/
			
	
			} else if(option == 4) {		
	
				/*
				System.out.println(" Supprimer une pizza" + "\ncode de la pizza : ");
				//reboot à zéro
				sc.nextLine();
				String codeToDelete = sc.nextLine();
				*/
				
				outilAccessData.listPizza(outilAccessData.findAllPizzas());
				System.out.println("Supprimer pizza : ");
				System.err.println("id : ");
				int idPizzaToDelete = sc.nextInt();
				
				try {
					outilAccessData.deletePizza(idPizzaToDelete);
				} catch (DeletePizzaException SupprimerPizzaExceptionCestPasBien) {
				 System.err.println(SupprimerPizzaExceptionCestPasBien.getMessage());
				}
		
				

			} if(option == 5) {
				/*
				IncreasingCode increasingCode = new IncreasingCode();
				Collections.sort(pizzas, increasingCode);
				System.out.println("Tri du code par ordre croissant");
				outilAccessData.listPizza();
				*/
				System.err.println("Type de pizza :");
				TypePizzaDao.listTypePizza(TypePizzaDao.findAllTypePizza());
				sc.nextLine();
				TypePizzaDao.listPizza(TypePizzaDao.findPizzasByTypeName(sc.nextLine()));
				
				
			} else if(option == 6) {
				DecreasingPrice decreasingPrice = new DecreasingPrice();
				pizzas = outilAccessData.findAllPizzas();
				Collections.sort(pizzas, decreasingPrice);
				System.out.println("tri par prix décroissant \r\n");
				outilAccessData.listPizza(pizzas);
				
			} else if(option == 7) {
				IncreasingCode increasingCode = new IncreasingCode();
				pizzas = outilAccessData.findAllPizzas();				
				Collections.sort(pizzas, increasingCode);
				System.out.println("tri par code croissant \r\n");
				outilAccessData.listPizza(pizzas);

			} else if(option == 8) {
				// Affiche les pizzas
				
				ConnectPizzeria connection = null;
				try {
					connection = ConnectPizzeria.getConnection();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RebotDatabase.delete(connection);
				RebootDatabase.add(connection);
			
			} else if(option == 99) {
			
				System.out.println("Get out of here ! ");
				next = false;
			/*
			} else if ((option < 1 && option > 4) ||(option != 99)) {
				System.out.println("Entre une option entre 1 et 4... Ou sors d'ici en tapant 99 :D");
			}
			*/
		}
	}



	}
}
