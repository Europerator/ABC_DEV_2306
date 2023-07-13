package Exercice2_6;
import java.math.*;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number;
		int i;
		boolean prime;
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Entrez le candidat de nombre premier : ");
		number = reader.nextInt();
		reader.close();
		if (number > 1) {
			prime = true;
		}
		else {
			prime = false;
		}
		for (i = 2; i < Math.sqrt(number)+1 && prime && number > 2; i++) {
			if (number % i == 0) {
				prime = false;
				System.out.println(number + " est divisible par " + i);
			}
		}
		if (prime) {
			System.out.println(number + " est un nombre premier.");
		}
		else {
			System.out.println(number + " n'est pas un nombre premier.");
		}
	}

}
