package Exercice2_2;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a;
		int b;
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Programme de tri croissant de deux nombres.");
		System.out.println("Entrez la valeur de A : ");
		a = reader.nextInt();
		System.out.println("Entrez la valeur de B : ");
		b = reader.nextInt();
		if (a < b) {
			System.out.println("A = " + a + ", B = " + b + ".");
		}
		else if (a > b) {
			System.out.println("B = " + b + ", A = " + a + ".");
		}
		else {
			System.out.println("Les deux nombres sont égaux");
		}
		reader.close();
	}

}
