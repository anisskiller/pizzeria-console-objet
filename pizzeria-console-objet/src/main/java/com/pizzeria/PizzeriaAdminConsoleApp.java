package com.pizzeria;

import java.util.Scanner;

import classe.Pizza;

public class PizzeriaAdminConsoleApp {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean next = true;
		int option = 0;
		
		Pizza[] pizzas = {
				new Pizza("PEP","Péperoni",12.50),
				new Pizza("MAR","Margherita",14.00),
				new Pizza("REIN","La Reine",11.50),
				new Pizza("FRO","La 4 fromages",12.00),
				new Pizza("CAN","La cannibale",12.50),
				new Pizza("SAV","La savoyarde",13.00),
				new Pizza("ORI","L'orientale",13.50),
				new Pizza("IND","L'indienne",14.00)
		};



		while(next == true) {
			System.out.println("***** Pizzeria Administration *****" + "\n1.	  Lister les pizzas" + "\n2.	  Ajouter une nouvelle pizza" + "\n3.	  Mettre à jour une pizza" + "\n4.	  Supprimer une pizza" + "\n99.	  Sortir");



 	option = sc.nextInt();

 	// switch (option) {

 	if(option == 1) {
		System.out.println(" Liste des pizzas");
		
		for (Pizza pizza : pizzas) {
			System.out.println(pizza.toString());			
		}
		// break;
 	} else if(option == 2) {
	
	System.out.println(" Ajout d'une nouvelle pizza");
	// remise a 0 du scanner
	sc.nextLine();
	
	System.out.println(" Veuillez saisir le code :");
	String code = sc.nextLine();
	
	System.out.println(" Veuillez saisir le nom (sans espace) :");
	String nom = sc.nextLine();
				
	System.out.println(" Veuillez saisir le prix :");	
	double prix = sc.nextDouble();
	
	// déclaration d'un tableau provisoire de pizza et attribution des valeurs de l'ancien tableau
	Pizza [] pizzasProvisoire = new Pizza[pizzas.length+1];			
	System.out.println(pizzasProvisoire.length);
	for(int i = 0; i<pizzas.length; i++) {
		pizzasProvisoire[i] = pizzas[i];
		
	}
	
	// changment de la taille de l'ancien tableau et recuperation des anciennes valeurs
	pizzas = pizzasProvisoire;
	
	
	// rajout a la fin du tableau de la nouvelle pizza
	Pizza pizzaToAdd = new Pizza(code, nom, prix);
	pizzas[pizzas.length-1] = pizzaToAdd;
	
			// break;
 	} else if(option ==3) {
	
	
	System.out.println(" Mise à jour d'une pizza");
	
	// remise a 0 du scanner
	sc.nextLine();
	
	// affichage des pizza
	System.out.println(" Liste des pizzas");
	for (Pizza pizza : pizzas) {
		System.out.println(pizza.toString());		
	}
	
	System.out.println("code de la pizza que tu veux modifier : ");
	String codePizza = sc.nextLine();
	
	// instanciation d'une nouvelle pizza pour la modifier
	Pizza editPizza = new Pizza();
	
	System.out.println(codePizza);
	// recuperation de la pizza a modifier dans le tableau
	for (Pizza pizza : pizzas) {
		System.out.println(pizza.getCode());
		if(pizza.getCode().equals(codePizza)) {
			editPizza = pizza;
			
	
		
			// saisie des valeurs
			System.out.println(" Veuillez saisir le nouveau code :");
			String editCode = sc.nextLine();
			
			System.out.println(" Veuillez saisir le nouveau nom (sans espace) :");
			String editNom = sc.nextLine();
			
			System.out.println(" Veuillez saisir le nouveau prix :");
			Double editPrix = sc.nextDouble();
			
			
			// modification de la pizza
			editPizza.setCode(editCode);
			editPizza.setDesignation(editNom);
			editPizza.setPrix(editPrix);
			
			
			//rajout au tableau
			pizzas[editPizza.getId()] = editPizza;
			
		}
		
	}
	//break;
	
 	} else if(option == 4) {		
	
	
	System.out.println(" Supprimer une pizza" + "\ncode de la pizza : ");
	//remise a 0 
	sc.nextLine();
	
	String codeToDelete = sc.nextLine();
		
	
	// creation d'un tableau temporaire plus petit que l'ancien
		Pizza [] pizzasProvisoire2 = new Pizza[pizzas.length-1];
		
		
	// utilisation d'une variable i pour lajout des pizza a garder dans le tableau
		int i = 0;
		for (Pizza deletePizza : pizzas) {
			// si le code de la pizza n'est pas celui a supprimer on le rajoute au tableau
			if(!deletePizza.getCode().equals(codeToDelete)) {
			pizzasProvisoire2[i] = deletePizza;
			i++;
			}
		}
		
		// modification de la taille de l'ancien tableau et copie des données
		pizzas = new Pizza[pizzasProvisoire2.length];
		pizzas = pizzasProvisoire2;

 	} else if(option == 99) {
	System.out.println("Get out of here ! ");
	next = false;

 	} else if ((option < 1 && option > 4) ||(option != 99)) {
 		System.out.println("Entre une option entre 1 et 4... Ou sors d'ici en tapant 99 :D");
 	}
		}
	}



	
}
