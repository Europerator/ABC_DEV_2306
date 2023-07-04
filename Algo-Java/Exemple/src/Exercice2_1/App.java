package Exercice2_1;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int age;
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Programme de détermination de majorité.");
		System.out.println("Entrez votre âge en années : ");
		age = reader.nextInt();
		if (age > 17) {
			System.out.println("Vous êtes majeur(e).");
		}
		else {
			if (age < 0) {
				System.out.println("Vous n'êtes pas encore né(e), donc...");
			}
			System.out.println("Vous êtes mineur(e).");
		}
		reader.close();
	}

}
