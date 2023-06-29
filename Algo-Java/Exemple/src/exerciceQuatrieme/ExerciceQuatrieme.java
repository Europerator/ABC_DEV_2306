package exerciceQuatrieme;

import java.util.Scanner;

public class ExerciceQuatrieme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double sum;
		double interest;
		int years;
		double result;
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Programme de calcul des intérêts.");
		System.out.println("Veuillez entrer la somme placée sur le compte : ");
		sum = reader.nextDouble();
		System.out.println("Veuillez entrer l'intérêt offert par la banque : ");
		interest = reader.nextDouble();
		System.out.println("Veuillez entrer le nombre (entier) d'années de placement : ");
		years = reader.nextInt();
		result = sum * (1 + years * interest);
		System.out.println("Avec un intérêt simple, le compte aura acquis la valeur de : " + result);
		result = sum * Math.pow((1 + interest), years);
		System.out.println("Avec un intérêt composé, le compte aura acquis la valeur de : " + result);
		reader.close();
	}

}
