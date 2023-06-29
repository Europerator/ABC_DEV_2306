package exerciceSecond;

import java.util.Scanner;

public class ExerciceSecond {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double radius;
		double area;
		double volume;
		final double pi = Math.PI;
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Programme de calcul de l'aire et du volume d'une sphère.");
		System.out.println("Veuillez entrer le raoyon de la sphère : ");
		radius = reader.nextFloat();
		area = Math.pow(radius,  2) * pi * 4;
		volume = area * radius / 3;
		System.out.println("Une sphère de rayon " + Double.toString(radius) + " a une aire de " + Double.toString(area) + " et un volume de " + Double.toString(volume) + ".");
		reader.close();
	}

}
