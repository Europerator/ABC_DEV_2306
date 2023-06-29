package exerciceTroisieme;

import java.util.Scanner;

public class ExerciceTroisieme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double radius;
		double angle;
		double area;
		final double PI = Math.PI;
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Programme de calcul de l'aire d'un secteur circulaire.");
		System.out.println("Veuillez entrer le rayon du secteur circulaire : ");
		radius = reader.nextDouble();
		System.out.println("Veuillez entrer l'angle du secteur circulaire : ");
		angle = reader.nextDouble();
		area = Math.pow(radius,2) * angle * PI / 360;
		System.out.println("L'aire d'un secteur circulaire de rayon " + radius + " et d'angle " + angle + " est de : " + area + ".");
		reader.close();
	}

}
