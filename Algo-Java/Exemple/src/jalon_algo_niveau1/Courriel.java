package jalon_algo_niveau1;

import java.util.Scanner;

public class Courriel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String firstName;
		String lastName;
		String department;
		String FirstnameFirst;
		String FirstnameLast;
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Programme de suggestion d'adresses courriel.");
		System.out.println("Entrez votre nom : ");
		lastName = reader.next();
		System.out.println("Entrez votre prénom : ");
		firstName = reader.next();
		System.out.println("Entrez votre numéro de département : ");
		department = reader.next();
		FirstnameFirst = firstName + "." + lastName + department + "@arfp.asso.fr";
		FirstnameLast = lastName + "." + firstName + department + "@arfp.asso.fr";
		System.out.println("Les adresses proposées sont les suivantes : " + FirstnameFirst + " et " + FirstnameLast);
		reader.close();

	}
}
