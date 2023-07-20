package jalon_algo_3;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Declaration
		int number;
		char cont = 'O';
		Scanner reader = new Scanner(System.in);
		
		//Start program
		System.out.println("Affichage de table de multiplication.");
		while (cont == 'O') {
			number = 0;
			while (number < 1 || number > 10) {
				System.out.println("Entrez un nombre entre 1 et 10 : ");
				number = reader.nextInt();
			}
			for (int i = 0; i < 11; i++) {
				System.out.println(i + " x " + number + " = " + i*number);
			}
			cont = ' ';
			while (cont != 'O' && cont != 'N') {
				System.out.println("Souhaitez-vous afficher une autre table ? (O/N)");
				cont = reader.next().charAt(0);
			}
		}
		System.out.println("Fin du programme.");
		reader.close();
	}

}
