package jalon_algorithme_20230727;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int position;
		int nb;
		String resultat;
		long nbPrecedent;
		long nbCourant;
		long nbSuivant;
		boolean quit = false;
		Scanner reader = new Scanner(System.in);
		do {
			System.out.println("Combien de nombres de la suite de Fibonacci souhatez-vous afficher ? (0 pour quitter)");
			nb = reader.nextInt();
			resultat = "\t0\n\t1";
			if (nb > 1) {
				position = 2;
				nbPrecedent = 0;
				nbCourant = 1;
				while (position < nb) {
					nbSuivant = nbPrecedent + nbCourant;
					resultat = resultat + "\n\t" + nbSuivant;
					nbPrecedent = nbCourant;
					nbCourant = nbSuivant;
					position++;
				}
			}
			else {
				if (nb == 0) {
					quit = true;
				}
				nb = 2;
			}
			System.out.println("Les " + nb + " premiers nombres de la suite de Fibonacci sont \n" + resultat);
		} while (!quit);
		reader.close();
		System.out.println("Fin du programme.");
	}

}
