package Exercice2_7;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double distance;
		String input;
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Entrez une valeur en kilomètres : ");
		input = reader.next();
		while (!input.equals("Q") && !input.equals("q")) {
			distance = Double.parseDouble(input);
			if (distance > 0.01d && distance < 1000000d) {
				System.out.println(distance + "km font " + distance/1.609d + " miles.");
			}
			else {
				System.out.println("Erreur, veuillez entrer une valeur entre 0.01km et 1 000 000km.");
			}
			input = reader.next();
		}
		reader.close();
	}

}
