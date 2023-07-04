package Exercice2_4;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year;
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Programme de l'année bissextile.");
		System.out.println("Entrez l'année : ");
		year = reader.nextInt();
		reader.close();
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println("Bissextile.");
		}
		else {
			System.out.println("Non bissextile.");
		}
	}

}
