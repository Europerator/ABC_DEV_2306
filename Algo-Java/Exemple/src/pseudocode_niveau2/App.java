package pseudocode_niveau2;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input;
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Le ou la client(e) est-il/elle etudiant(e) : ");
		input = " ";
		while (!input.equals("o") && !input.equals("n")) {
			System.out.println("(o/n)");
			input = reader.next();
		}
		if (input.equals("o")) {
			System.out.println("Entrez le numero du jour de la semaine.");
			while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5") && !input.equals("6") && !input.equals("7")) {
				System.out.println("(1-7)");
				input = reader.next();
			}
			if (input.equals("3")) {
				System.out.println("Une reduction de 50% s'applique.");

			}
			else if (input.equals("4")) {
				System.out.println("Une reduction de 20% s'applique.");
			}
			else {
				System.out.println("Aucune reduction ne s'applique.");
			}
		}
		else {
			System.out.println("Aucune reduction ne s'applique.");
		}
		reader.close();
	}

}
