package exercicePremier;

import java.util.Scanner;

public class PremierPremier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int firstNumber;
	int secondNumber;
	double result;
	Scanner reader = new Scanner(System.in);
	
	System.out.println("Programme de calcul de la moyenne de deux nombres.");
	System.out.println("Veuillez saisir un premier nombre : ");
	firstNumber = reader.nextInt();
	System.out.println("Veuillez saisir un second nombre : ");
	secondNumber = reader.nextInt();
	result = (firstNumber + secondNumber) / 2;
	System.out.println("La moyenne de " + Integer.toString(firstNumber) + " et " + Integer.toString(secondNumber) + " est de : " + Double.toString(result));
	reader.close();
	}

}
