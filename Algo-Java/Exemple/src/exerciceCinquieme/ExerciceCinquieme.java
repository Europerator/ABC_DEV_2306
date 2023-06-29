package exerciceCinquieme;

import java.util.Scanner;

public class ExerciceCinquieme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a;
		int b;
		int c;
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Programme d'inversion de nombre entiers.");
		System.out.println("Veuillez entrer le nombre A : ");
		a = reader.nextInt();
		System.out.println("Veuillez entrer le nombre B : ");
		b = reader.nextInt();
		System.out.println("Les nombres sont a = " + a + " et b = " + b + ".");
		c = a;
		a = b;
		b = c;
		System.out.println("\u00C0 présent, a = " + a + " et b = " + b + ".");
		reader.close();
	}

}
