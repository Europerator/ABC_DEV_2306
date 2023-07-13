package Exercice2_5;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number;
		int i;
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Entrez un entier : ");
		number = reader.nextInt();
		reader.close();
		for (i = 2; i < number/2 + 1; i++) {
			if (number%i == 0) {
				System.out.println(number + " est divisible par " + i + ".");
			}
		}
	}

}
