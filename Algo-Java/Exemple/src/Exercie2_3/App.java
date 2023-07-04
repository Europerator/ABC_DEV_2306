package Exercie2_3;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a;
		double b;
		double c;
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Programme de tri de trois nombres.");
		System.out.println("Entrez la valauer du nombre A : ");
		a = reader.nextDouble();
		System.out.println("Entrez la valeur du nombre B : ");
		b = reader.nextDouble();
		System.out.println("Entrez la valeur du nombre C : ");
		c = reader.nextDouble();
		if (a <= b && a <= c) {
			System.out.print("A = " + a);
			if (b < c) {
				System.out.print(", B = " + b + ", C = " + c);
			}
			else {
				System.out.print(", C = " + c + ", B = " + b);
			}
		}
		else if (b <= a && b <= c) {
			System.out.print("B = " + b);
			if (a < c) {
				System.out.print(", A = " + a + ", C = " + c);
			}
			else {
				System.out.print(", C = " + c + ", A = " + a);
			}
		}
		else {
			System.out.print("C = " + c);
			if (a < b) {
				System.out.print(", A = " + a + ", B = " + b);
			}
			else {
				System.out.print(", B = " + b + "A = " + a);
			}
		}
		reader.close();
		
	}

}
