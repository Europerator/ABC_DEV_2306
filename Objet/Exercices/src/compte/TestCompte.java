package compte;

public class TestCompte {

	public static void main(String[] args) {
		Compte toutlargent = new Compte(999.99d);
		toutlargent.afficher();
		toutlargent.deposer(0.01d);
		toutlargent.afficher();
		toutlargent.retirer(500d);
		toutlargent.afficher();
	}

}
