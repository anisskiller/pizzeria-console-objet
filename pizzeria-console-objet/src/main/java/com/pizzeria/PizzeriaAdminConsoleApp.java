package com.pizzeria;
import classe.PizzaMemDao;

import java.util.Scanner;

import com.pizzeria.model.CategoriePizzaEnum;

import java.util.Collections;
import java.util.List;

import exception.DeletePizzaException;
import exception.SavePizzaException;
import exception.StockageException;
import exception.UpdatePizzaException;
import classe.DecreasingPrice;
import classe.IncreasingCode;
import classe.Pizza;


public class PizzeriaAdminConsoleApp {
	
	public static <T> void main(String[] args) {
		// PizzaMemDao pizza = new PizzaMemDao();
		
		// Pizza [] pizzas = dao.findAllPizzas(); 
		Scanner sc = new Scanner(System.in); 
		
		boolean next = true;
		int option = 0;

		PizzaMemDao outilAccessData = new PizzaMemDao();
		
		List<Pizza> pizzas = outilAccessData.findAllPizzas();

		
		
		



		while(next == true) {
			
			System.out.println("***** Pizzeria Administration *****" + 
		"\n1.	  Lister les pizzas" + "\n2.	  Ajouter une nouvelle pizza" + 
		"\n3.	  Mettre à jour une pizza" + "\n4.	  Supprimer une pizza" + 
		"\n5. Trier les pizza par prix decroissant" + "\n6. Trier les pizza par prix Croissant"
		+ "\n99.	  Sortir");



		option = sc.nextInt();

		if(option == 1) {
			
			System.out.println(" Liste des pizzas");
			
			outilAccessData.listPizza();
		
			

		} else if(option == 2) {
	
			System.out.println(" Ajout d'une nouvelle pizza");
			// remise a 0 du scanner
			sc.nextLine();
	
			System.out.println(" le code :");
			String code = sc.nextLine();
	
			System.out.println(" le nom :");
			String nom = sc.nextLine();
				
			System.out.println(" le prix :");	
			double prix = sc.nextDouble();
			
			System.out.println("categorie");
			sc.nextLine();
			
			try {
				// verification du type de pizza et presence du type
				CategoriePizzaEnum categorie = CategoriePizzaEnum.valueOf(sc.nextLine().toUpperCase());
				Pizza pizzaToAdd = new Pizza(code, nom, prix, categorie);
				outilAccessData.addPizza(pizzaToAdd);
			} catch (SavePizzaException SauvegarderPizzaExceptionCestPasBien) {
			
			System.err.println(SauvegarderPizzaExceptionCestPasBien.getMessage());
				
			// si le type de pizza existe pas on le met dans autre
			} catch (IllegalArgumentException IllegalCestPasBien) {
				System.out.println("La catégorie n'y est pas ");
				Pizza addPizza = new Pizza(code, nom, prix, CategoriePizzaEnum.AUTRE);
				try {
					outilAccessData.addPizza(addPizza);
				} catch (SavePizzaException SauvegarderPizzaExceptionCestPasBien) {
					System.err.println(SauvegarderPizzaExceptionCestPasBien.getMessage());
				
				}
			}
	

	
			} else if(option ==3) {
	
				System.out.println(" Mise à jour d'une pizza");
				
				// remise a 0 du scanner
				sc.nextLine();
				
				// Lister les pizza
				outilAccessData.listPizza();
				
				System.out.println("Veuillez choisir le code de la pizza à modifier");
				String codePizza = sc.nextLine();
				
				// Saisie des nouveaux paramètres
				System.out.println(" Nouveau code :");
				String nouveauCode = sc.nextLine();
				System.out.println(" Nouveau nom :");
				String nouveauNom = sc.nextLine();			
				System.out.println(" Nouveau pirx :");
				Double nouveauPrix = sc.nextDouble();
				sc.nextLine();
				System.out.println(" Catégorie :");	
				CategoriePizzaEnum categorie;
				
				try {
					// verification du type de pizza et presence du type
					 categorie = CategoriePizzaEnum.valueOf(sc.nextLine().toUpperCase());
				}catch (IllegalArgumentException et) {
					System.err.println("Ce type de pizza n'existe pas, pizza ajoutée a la categorie Autre");
					 categorie = CategoriePizzaEnum.AUTRE;
				}
				// instanciation d'une nouvelle pizza pour la modifier
				Pizza editPizza = new Pizza();
				
				// modification de la pizza
				editPizza.setCode(nouveauCode);
				editPizza.setDesignation(nouveauNom);
				editPizza.setPrix(nouveauPrix);
				editPizza.setCategoriePizza(categorie);
				
				try{
					outilAccessData.updatePizza(codePizza, editPizza);
				}catch(UpdatePizzaException modifierPizzaExceptionCestPasBien) {
					
					System.err.println(modifierPizzaExceptionCestPasBien.getMessage());
				}
	
	
			} else if(option == 4) {		
	
				System.out.println(" Supprimer une pizza" + "\ncode de la pizza : ");
				//reboot à zéro
				sc.nextLine();
	
				String codeToDelete = sc.nextLine();
				
				try {
					outilAccessData.deletePizza(codeToDelete);
				} catch (DeletePizzaException SupprimerPizzaExceptionCestPasBien) {
				 System.err.println(SupprimerPizzaExceptionCestPasBien.getMessage());
				}
		
				

			} if(option == 5) {
				IncreasingCode increasingCode = new IncreasingCode();
				
				Collections.sort(pizzas, increasingCode);
				System.out.println("Tri du code par ordre croissant");
				outilAccessData.listPizza();
			} else if(option == 6) {
				DecreasingPrice decreasingPrice = new DecreasingPrice();
				
				Collections.sort(pizzas, decreasingPrice);
				System.out.println("trié par prix décroissant \r\n");
				outilAccessData.listPizza();
			
			} else if(option == 99) {
			
				System.out.println("Get out of here ! ");
				next = false;

			} else if ((option < 1 && option > 4) ||(option != 99)) {
				System.out.println("Entre une option entre 1 et 4... Ou sors d'ici en tapant 99 :D");
			}
		}
	}



	
}
