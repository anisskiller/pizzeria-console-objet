package com.pizzeria;

import java.util.Scanner;

import classe.Pizza;

public class PizzeriaAdminConsoleApp {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		boolean outOfBoucle = false;
		int choice = 0;

		// on affiche le menu en référençant la méthode de la classe Pizza
		System.out.println(Pizza.afficheMenu());
		
		/**
		 * afficher le menu tant que l'utilisateur n'entre pas 99
		 * */

		while(!outOfBoucle) {
			System.out.println("\nFaîtes votre choix :D ");
			choice = sc.nextInt();
			if(choice == 1) { // Lister les pizzas
				System.out.println(" ");
				System.out.println(Pizza.afficheMenu());
				System.out.println("\nMargarita " + "\nAustralienne " + "\nOrientale " + "\nNapolitaine");
			} else if(choice == 2) { // Ajouter pizza 
				System.out.println(" ");
				System.out.println(Pizza.afficheMenu());
				System.out.println("\nPizza ajouté frérot");
			} else if(choice == 3) { // Mise à jour d'un pizza
				System.out.println(" ");
				System.out.println(Pizza.afficheMenu());
				System.out.println("Mise à jour d’une pizza");
			} else if(choice == 4) { // Supprimer une piza
				System.out.println(" ");
				System.out.println("Suppression d’une pizza");
				System.out.println(Pizza.afficheMenu());
			} else if (choice == 99) { // On sort de la boucle
				System.out.println(" ");
				System.out.println("Get out of here ! ");
				outOfBoucle =true;
				// break;
			} else if (choice != 1 || choice != 2 || choice != 3 || choice != 4 || choice != 99) {
				System.out.println("Invalid Command : enter 1 or 2 or 3 or 4 or 99 pleaaaaase");
			}
			
		}
	}
}
